@import exercise.dto.users.UsersPage
@param UsersPage page

<html>
    <head>
        <title>Users</title>
    </head>
    <body>
        <h1>${page.getHeader()}</h1>
        @if(page.getUsers().isEmpty())
            <p>No users available</p>
        @else
            @for(var user : page.getUsers())
               <div>
                   <h2><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>
               </div>
            @endfor
        @endif
    </body>
</html>
