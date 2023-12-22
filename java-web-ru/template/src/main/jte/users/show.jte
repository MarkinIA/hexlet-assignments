@import exercise.dto.users.UserPage
@param UserPage page

<html>
<head>
    <title>User</title>
</head>
<body>
<div>
    <h1>Detail info</h1>
    <dl>
        <dt>FIO:</dt>
        <dd>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</dd>
        <dt>Email:</dt>
        <dd>${page.getUser().getEmail()}</dd>
        <dt>Id:</dt>
        <dd>${page.getUser().getId()}</dd>
    </dl>
</div>
</body>
</html>