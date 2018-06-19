xquery version "3.1";

declare namespace output = "http://www.w3.org/2010/xslt-xquery-serialization";

declare option output:method "html5";
declare option output:media-type "text/html";

let $wiki-info :=
    <wikis>
    {
        for $resource in collection('/db/db_lab2/xmls2')
        return
            <wiki url="{base-uri($resource)}"
                name="{util:unescape-uri(replace(base-uri($resource),
                ".+/(.+)$", "$1"), "UTF-8")}"
                title="{data($resource/data/page/@name)}"
                id="{data($resource/data/page/@id)}"
                wiki-url="{data($resource/data/page/@url)}">
            {
                $resource
            }
            </wiki>
    }
    </wikis>
return
    <html>
        <head>
            <title>Main Page</title>
            <!-- Latest compiled and minified CSS -->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
                integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
            </link>
            <!-- Optional theme -->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
                integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
            </link>
        </head>
        <body>
            <h1><center>WIKI API</center></h1>
            <h3><center>Var1</center></h3>
            <div class="row">
                <div class="col-lg-6">
                    <div class="input-group">
                        <form action="/action_page.php" method="get" id="form1">
                            <input type="text" name="searchphrase" class="form-control" placeholder="Search for full-text..."/>
                        </form>
                        <span class="input-group-btn">
                            <button class="btn btn-default" form="form1" formmethod="POST" formtarget="_blank" 
                                    formaction="/exist/rest/db/db_lab2/lab2_search.xql" type="submit">Go!</button>
                        </span>
                    </div>
                </div>
            </div>
            <br></br>
            <div class="list-group">
                {
                    for $wiki in $wiki-info/wiki
                    let $path := fn:concat("/exist/rest/db/db_lab2/lab2_mainInfo.xql?pageId=", string(data($wiki/@id)))
                    return
                            <a href="{string($path)}" target="_blank" class="list-group-item">
                                <h3 class="list-group-item-heading"><b>{string(data($wiki/@title))}</b></h3>
                                <p class="list-group-item-text"><i>Wiki URL: </i>{string($wiki/@wiki-url)}</p>
                                <p class="list-group-item-text"><i>Name XML file: </i>"{string($wiki/@name)}"</p>
                            </a>
                        
                }
            </div>
            <!-- Latest compiled and minified JavaScript -->
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
                integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        </body>
    </html>
    
    
    