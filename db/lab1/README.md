# Lab №1
#### **Topic:** Study basic processing of XML documents.
#### **Objective:** Acquiring practical skills in creating programs, oriented *XML* document processing using *Python*.

### Task options:
1. Perform the collection of information from the Web site pages optionally.
2. Run an analysis of the Web site pages for further processing of the text and
graphic information hosted on it.
3. Implement the functionality according to the requirements listed below.

### Functional requirements:
1. Bypass the existing pages based on the base address of the Web site
separating text and image information from HTML tags.
Search for hosts by means of XPath. Next page for analysis
select the same site as one of the hyperlinks on this page. Limit analysis to 20 pages of the site. Save XML to
as a file. XML document format:

        ```
        <data>
          <page url=”wwww.server.com/index.hml”>
            <fragment type=”text”>
              …. (found text)
            </fragment>
            <fragment type=”image”>
              …. (url img)
            </fragment>
          </page>
          <page url=”wwww.server.com/index1.hml”>
            <fragment type=”text”>
              …. (found text)
            </fragment>
            <fragment type=”image”>
              …. (url img)
            </fragment>
          </page>
          …
        </data>
        ```
        
2. Perform the analysis of the data received by XML tools according to the option and
display results in the console window. Selection of nodes and calculations for
option to *run XPath*.

3. Analyze the content of Web-pages of the online store (see option).
Get the price, description and image for 20 items from it using
*DOM-parser* and *XPath languages* to search for corresponding nodes. Result
write to *XML file*.

4. Convert the resulting *XML file* to *XHTML* using
*XSLT language*. Submit data as an *XHTML* spreadsheet and save it in
file.

Option: 
- Base page (task 1): *www.kpi.ua*
- Contents of the task 2: *Maximum number text snippets*
- Address online store (task 3): *www.rozetka.ua*
