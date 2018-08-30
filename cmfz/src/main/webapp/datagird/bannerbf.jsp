<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
    $(function () {

        var toolbar = [{
            iconCls: 'icon-add',
            text: "添加",
            handler: function () {
                //录入数据
                $("#dia").dialog({
                    title: "添加轮播图",
                    width: 550,
                    height: 350,
                    iconCls: 'icon-man',
                    draggable: false,
                    buttons: [{
                        text: '保存',
                        iconCls: 'icon-save'
                    }, {
                        text: '关闭',
                        iconCls: 'icon-cancel'
                    }]
                });

                $("#form").form({
                    url: "${pageContext.request.contextPath}/banner/save",
                    onSubmit: function (param) {
                        return true;
                    },
                    success: function (data) {
                    },
                });
                //hander function()-----------
            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-cancel',
            handler: function () {
                // ---------删除数据


                // ---------删除数据
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                //使当前选中行可编辑模式
                var row = $("#dg").edatagrid("getSelected");
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
            updateUrl: "${pageContext.request.contextPath}/cmfz/banner/add",
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
            pageSize: 2,
            pageList: [2, 10, 15, 20],
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
</script>

<table id="dg"></table>


<div id="dia" style="display: none">
    <form id="form">
        <table align="center">
            <tr>
                <td>title：</td>
                <td><input id="title" name="banner.title" type="text" data-options="requried:true"
                           style="width: 150px"/></td>
            </tr>
            <tr>
                <td>imgPath：</td>
                <td><input id="imgPath" name="banner.imgPath" type="text" data-options="requried:true"
                           style="width: 150px"/></td>
            </tr>
            <tr>
                <td>description：</td>
                <td><input id="description" name="banner.description" type="text" data-options="requried:true"
                           style="width: 150px"/></td>
            </tr>
            <tr>
                <td>status：</td>
                <td><input id="status" name="banner.status" type="text" data-options="requried:true"
                           style="width: 150px"/></td>
            </tr>
            <tr>
                <td>createDate：</td>
                <td><input id="createDate" name="banner.createDate" type="text" data-options="requried:true"
                           style="width: 150px"/></td>
            </tr>
        </table>
    </form>
</div>
