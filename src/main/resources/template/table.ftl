<#ftl output_format="XML">
<html>
<head>
    <style>
        table {
            -fs-table-paginate: paginate;
        }
        @page {
            margin-top: 30mm;
            @top-center {content: element(header);}
            @bottom-left {  content: "Test Page";  }
            @bottom-right {  content: counter(page) " of " counter(pages);  }
        }
        #header {
            display: block;
            border: 1px solid #999;
            position: running(header);
        }

    </style>
</head>
<body>
<div id="header">
    Hello world
</div>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Country</th>
    </tr>
    </thead>
    <tbody>
    <#list list as record>
        <tr>
            <td>${record.id}</td>
            <td>${record.value}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>