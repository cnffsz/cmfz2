<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
    $(function () {
        var toolbar = [{
            iconCls: 'icon-add',
            text: "专辑详情",
            handler: function () {
                var row = $("#albumtid").treegrid("getSelected");
                if (row != null) {
                    if (row.author != null) {

                        $("#albumdd").dialog("open");
                        $("#albumff").form('load', row);
                        $('img').prop('src', "${pageContext.request.contextPath}/upload" + row.corverimg);
                    } else {
                        alert("请选中专辑");
                    }
                } else {
                    alert("请选中行");
                }
            }
        }, '-', {
            text: "添加专辑",
            iconCls: 'icon-add',
            handler: function () {
                $("#albumadd").dialog("open");

            }
        }, '-', {
            text: "添加章节",
            iconCls: 'icon-add',
            handler: function () {
                var row = $("#albumtid").treegrid("getSelected");

                if (row != null) {
                    if (row.author != null) {
                        //alert(row.id)//从前台获取专辑id传给后台
                        $("#divchaptersaveid").dialog("open");
                        /*把选中的专辑数据封装到row，然后通过 load方法传给form表单
                         *通过name自动匹配
                         */
                        $("#formchaptersave").form('load', row);

                    } else {
                        alert("请选中专辑");
                    }
                } else {
                    alert("请选中行");
                }

            }
        }, '-', {
            text: "下载音频",
            iconCls: 'icon-add',
            handler: function () {
                var row = $("#albumtid").treegrid("getSelected");
                if (row != null) {
                    if (row.author != null) {
                        location.href = "${pageContext.request.contextPath}/chapter/down?url=" + row.url + "&name=" + row.name
                    } else {
                        alert("请选中专辑");
                    }
                } else {
                    alert("请选中行");
                }
            }
        }]

        $('#albumtid').treegrid({
            onDblClickRow: function (row) {
                $("#audiodivid").dialog("open")//
                $("#audio").prop("src", "${pageContext.request.contextPath}/" + row.audioPath)
                //$("#audio").prop("src", "${pageContext.request.contextPath}/musicfile/" + row.audioPath)
            },
            url: '${pageContext.request.contextPath}/album/queryAll',
            method: "post",
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'title', title: '名称', width: 60},
                {field: 'size', title: '大小', width: 60},
                {field: 'audioPath', title: '路径', width: 80},
                {field: 'duration', title: '时长', width: 80}
            ]],
            fit: true,
            fitColumns: true,
            toolbar: toolbar,
        });
    })
    //点击下载音频，弹出的dialog底部有保存，点击保存则保存数据到url去执行
    //添加专辑提交的地址
    function submitalbum() {
        $("#addalbumform").form("submit", {
            url: "${pageContext.request.contextPath}/album/save"
        })
    }
    // 添加章节音频提交的地址
    function submitchapter() {
        $("#formchaptersave").form("submit", {
            url: "${pageContext.request.contextPath}/chapter/save"
        })
    }
</script>

<table id="albumtid"></table>
<!--专辑详情-->
<div id="albumdd" class="easyui-dialog" title="专辑详情" style="width:500px;height:400px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'关闭',
				handler:function(){
                     $('#albumdd').dialog('close');
				}
			}]">
    <form id="albumff" method="post" enctype="multipart/form-data">
        <table align="center">
            <tr>
                <td>标题：</td>
                <td><input class="easyui-textbox" type="text" id="albumtitle" name="title" style="width: 200px"
                           disabled="disabled"/></td>
            </tr>
            <tr>
                <td>数量：</td>
                <td><input class="easyui-textbox" type="text" id="albumcount" name="count" style="width: 200px"
                           disabled="disabled"/></td>
            </tr>
            <tr>
                <td>简介：</td>
                <td><input class="easyui-textbox" type="text" id="brief" name="brief" style="width: 200px"
                           disabled="disabled"/></td>
            </tr>
            <tr>
                <td>封面：</td>
                <td><img src="" id="img" alt="" disabled="disabled"></td>
            </tr>
        </table>
    </form>
</div>
<!-- ---------添加专辑------ -->
<div id="albumadd" class="easyui-dialog" title="添加专辑" style="width:500px;height:400px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                     submitalbum();
                      $('#albumadd').dialog('close');
                      $('#albumtid').edatagrid('reload')
				}
			},{
				text:'关闭',
				handler:function(){
                     $('#albumadd').dialog('close');
				}
			}]">

    <form id="addalbumform" method="post" enctype="multipart/form-data">
        <table align="center">
            <tr>
                <td>标题：</td>
                <td><input class="easyui-validatebox" type="text" id="addtitle" name="title" style="width: 200px"/></td>
            </tr>
            <tr>
                <td>数量：</td>
                <td><input class="easyui-numberbox" type="text" id="addcount" name="count" style="width: 200px"/></td>
            </tr>
            <tr>
                <td>简介：</td>
                <td><input class="easyui-validatebox" type="text" id="addbrief" name="brief" style="width: 200px"/></td>
            </tr>
            <tr>
                <td>添加封面图片：</td>
                <td><input class="easyui-filebox" name="corverimg" style="width:200px"></td>
            </tr>
            <tr>
                <td>状态：</td>
                <td><select id="addcc" class="easyui-combobox" name="status" style="width:200px;">
                    <option value="Y">展示</option>
                    <option value="N">不展示</option>
                </select></td>
            </tr>
        </table>
    </form>
</div>
<!-- 添加章节音频-->
<div id="divchaptersaveid" class="easyui-dialog" title="添加章节音频" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                     submitchapter();
                      $('#divchaptersaveid').dialog('close');
                      $('#albumtid').edatagrid('reload')
				}
			},{
				text:'关闭',
				handler:function(){
                     $('#divchaptersaveid').dialog('close');
				}
			}]">
    <form id="formchaptersave" method="post" enctype="multipart/form-data">
        <table align="center">
            <tr>
                <td>标题：</td>
                <td><input class="easyui-textbox" type="text" id="ctitle" name="chaptertitle"
                           data-options="requried:true"
                           style="width: 200px"/></td>
            </tr>
            <tr>
                <td>添加音频：</td>
                <td><input class="easyui-filebox" name="music" style="width:200px"></td>
            </tr>
            <tr>
                <td>专辑id：</td>
                <td><input id="albid" name="id" style="width:200px" type="hidden"></td>
            </tr>
        </table>
    </form>
</div>

<div id="audiodivid" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <audio src="" id="audio" controls="controls" autoplay="autoplay">

    </audio>
</div>

