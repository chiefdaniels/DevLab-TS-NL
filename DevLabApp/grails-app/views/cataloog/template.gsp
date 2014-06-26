<g:applyLayout name="master">
    <content tag="content">
        <h1>Cataloog</h1>
        <ul>
            <g:each var="boek" in="${cataloog}">
                <g:render template="cataloogItem" model="['it':boek]"/>
            </g:each>
        </ul>
    </content>
</g:applyLayout>