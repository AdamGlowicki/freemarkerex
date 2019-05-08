<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

</head>
<body>
<h2>First name: ${student.firstName}</h2>
<h2>Last name: ${student.lastName}</h2>
<p>
    <#if student.active>
        <span class="active">active</span>
    <#else>
        <span class="inactive">inactive</span>
    </#if>
</p>
</body>
</html>