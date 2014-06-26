<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
	</head>
	<body>
        <div style="margin:1em 2em">
            <h1>Cataloog</h1>
            <small>Onderstaande blok wordt gerenderd via een call naar een controller/action, waarbij het resultaat in de gsp geplakt wordt ('include')</small>

            <div id="content">
                <g:include action="reuse_part"/>
            </div>
		</div>
    <small>Hier klikken maakt een ajax call naar dezelfde controller/action, zo wordt ajax wel heel gemakkelijk!</small>

    <button>Click me</button>
    <jq:resources />
    <script>
        $("button").click(function(){
            $("#content").html("Loading...");
            $.get(
                    '<g:createLink action="reuse_part"/>',
                    function(data){
                        $("#content").html(data);
            });
        })
    </script>
	</body>
</html>