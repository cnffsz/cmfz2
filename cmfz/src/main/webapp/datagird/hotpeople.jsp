<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>


<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="statistics_main" style="width: 600px;height: 400px;;margin-top: 30px;margin-left: 30px"></div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('statistics_main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '持名法州App活跃用户'
        },
        tooltip: {},
        legend: {
            data: ['男', '女']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '男',
            type: 'line',
            data: []
        }, {
            name: '女',
            type: 'scatter',
            data: []
        }]
    };

    myChart.setOption(option);
    // 异步加载统计信息
    $.ajax({
        url: "${pageContext.request.contextPath}/user/query",
        type: "post",
        dataType: "JSON",
        success: function (data) {
            myChart.setOption({
                xAxis: {
                    data: data.xAxis
                },
                series: [{
                    name: '男',
                    data: data.mans
                }, {
                    name: '女',
                    data: data.womens
                }]
            })
        }
    })
</script>
