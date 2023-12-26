@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
    <div>
        <h2>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h2>
    </div>
`
)