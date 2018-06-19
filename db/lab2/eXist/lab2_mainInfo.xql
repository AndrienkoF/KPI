xquery version "3.1";

declare namespace output = "http://www.w3.org/2010/xslt-xquery-serialization";
declare option output:method "html5";
declare option output:media-type "text/html";
declare variable $pageId := request:get-parameter("pageId", ());

declare variable $page-path as xs:string := fn:concat ("/db/db_lab2/xmls2/",string($pageId), ".xml");

<html>
    <head>
        <meta HTTP-EQUIV="Content-Type" content="text/html; charset=UTF-8"/>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
            integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        </link>
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
            integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        </link>
        <title>{string(doc($page-path)/data/page/@name)}</title>
    </head>
    <body>
        <div>
            <div class="list-group">
                <a href="#" class="list-group-item">
                    <h2 class="list-group-item-heading"><b>{string(doc($page-path)/data/page/@name)}</b></h2>
                    <p class="list-group-item-text">{string(doc($page-path)/data/page/summary)}</p>
                </a>
            
            {
                for $fragment in doc($page-path)/data/page/fragment
                return
                    
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading"><b>{string($fragment/@title)}</b></h4>
                            <p class="list-group-item-text">{string($fragment)}</p>
                        </a>
                    
            }
            </div>
        </div>
    
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>