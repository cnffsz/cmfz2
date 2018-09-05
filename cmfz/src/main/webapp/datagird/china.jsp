<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="statistics_china" style="width: 100%;height: 100%;margin-top: 30px;margin-left: 30px">
</div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('statistics_china'));
    function randomData() {
        return Math.round(Math.random() * 1000);
    }

    option = {
        title: {
            text: '持名法州APP用户分布图',
            subtext: 'xxxx年x月xx日 最新数据',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        // 说明
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['男', '女']
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'],           // 文本，默认为数值文本
            calculable: true
        },
        // 工具箱
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        series: [
            {
                name: '男',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: []
            },
            {
                name: '女',
                type: 'map',
                mapType: 'china',
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: []
            }
        ]
    }
    // 在此处把数据传递上去
    myChart.setOption(option)
    $.ajax({
        url: "${pageContext.request.contextPath}/user/china",
        type: "post",
        dataType: "JSON",
        success: function (data) {
            myChart.setOption({
                series: [{
                    // 根据名字对应到相应的系列
                    name: '男',
                    data: data.mans,
                }, {
                    // 根据名字对应到相应的系列
                    name: '女',
                    data: data.womens,
                }]
            })
        }
    })
    //$.post(
    //"${pageContext.request.contextPath}/user/china",
    /*function (data) {
     console.log(data);
     myChart.setOption({
     series: [{
     // 根据名字对应到相应的系列
     name: '男',
     data: data.mans,
     },{
     // 根据名字对应到相应的系列
     name: '男',
     data: data.womens
     }]
     });
     },
     "json");*/
    // $.post("${pageContext.request.contextPath}/user/china", function (data) {
    /* console.log(data);
     myChart.setOption({
     series: [{
     // 根据名字对应到相应的系列
     name: '女',
     data: data.womens,
     }]
     });
     }, "json");*/
    //});
</script>
