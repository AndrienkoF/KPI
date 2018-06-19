xquery version "3.1";

declare namespace output = "http://www.w3.org/2010/xslt-xquery-serialization";
declare option output:method "html5";
declare option output:media-type "text/html";
declare variable $page-title as xs:string := "Search";
declare variable $searchphrase := request:get-parameter("searchphrase", ());

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
        <title>{$page-title}</title>
    </head>
    <body>
        <h3>Serch phrase: "{$searchphrase}"</h3>
        <div class="list-group">
            {
                let $starttime as xs:time := util:system-time()
                (:for $line in collection("/db/db_lab2/xmls")//tei:p[contains(., $searchphrase)]:)
                for $line in collection("/db/db_lab2/xmls2")/data/page/summary
                [contains(., $searchphrase)]
                let $endtime as xs:time := util:system-time()
                return
                    <a href="#" class="list-group-item">
                        <h4 class="list-group-item-heading"><b>{string(root($line)/data/page/@name)}</b></h4>
                        <p class="list-group-item-text"><i>{string($line)}</i></p>
                        <br></br>
                        <p class="list-group-item-text">time: {seconds-from-duration($endtime - $starttime)}s"</p>
                    </a>
                    
            }
        </div>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>