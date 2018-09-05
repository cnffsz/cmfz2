<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
    $(function () {
        var toolbar = [{
            iconCls: 'icon-add',
            text: "添加",
            handler: function () {
                //录入数据
                $("#dd").dialog("open");
                //hander function()-----------
            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-cancel',
            handler: function () {
                // 删除数据
                //var deleteid = rows.id;
                $('#dg').edatagrid('destroyRow');
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                //使当前选中行可编辑模式
                var row = $("#dg").edatagrid("getSelected");
                //console.log(row)
                if (row != null) {

                    var index = $("#dg").edatagrid("getRowIndex", row)
                    //当前行可编辑
                    $("#dg").edatagrid("editRow", index)

                } else {
                    alert("请先选中行")
                }
            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-edit',
            handler: function () {
                $("#dg").edatagrid("saveRow")
            }
        }]

        $('#dg').edatagrid({
            url: '${pageContext.request.contextPath}/banner/queryByPage',
            method: "post",
            updateUrl: "${pageContext.request.contextPath}/banner/update",
            destroyUrl: "${pageContext.request.contextPath}/banner/delete",
            columns: [[
                {field: 'id', title: '编号', width: 100},
                {field: 'title', title: '名称', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                    type: "text",
                    options: {
                        required: true
                    }
                }
                },
                {field: 'description', title: '描述', width: 100},
                {field: 'createDate', title: '时间', width: 100}

            ]],
            fitColumns: true,
            fit: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 15, 20],
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.createDate + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
    })
    function submit() {
        $("#ff").form("submit", {
            url: "${pageContext.request.contextPath}/banner/save"
        })
    }
</script>

<table id="dg"></table>
<div id="dd" class="easyui-dialog" title="添加图片" style="width:400px;height:200px;"
	 data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                     submit();
                      $('#dd').dialog('close');
                      $('#dg').edatagrid('reload')
				}
			},{
				text:'关闭',
				handler:function(){
                     $('#dd').dialog('close');
				}
			}]">
	<form id="ff" method="post" enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td>标题：</td>
				<td><input class="easyui-textbox" type="text" id="title" name="title" data-options="requried:true"
						   style="width: 200px"/></td>
			</tr>
			<tr>
				<td>描述：</td>
				<td><input class="easyui-textbox" type="text" id="description" name="description"
						   data-options="requried:true" style="width: 200px"/></td>
			</tr>
			<tr>
				<td>状态：</td>
				<td><select id="cc" class="easyui-combobox" name="status" style="width:200px;">
					<option value="Y">展示</option>
					<option value="N">不展示</option>
				</select></td>
			</tr>
			<tr>
				<td>添加文件：</td>
				<td><input class="easyui-filebox" name="img" style="width:200px"></td>
			</tr>
		</table>
	</form>
</div>
