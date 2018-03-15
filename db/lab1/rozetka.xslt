 <xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <div class="toc-contents">
            <xsl:apply-templates/>
        </div>
    </xsl:template>

    <xsl:template match="part">
        <div class="toc-part">
            <h1><xsl:value-of select="@title"/></h1>
            <xsl:apply-templates select="chapter"/>
        </div>
    </xsl:template>

    <xsl:template match="chapter">
        <div class="toc-chapter">
            <img>
                <xsl:attribute name="src">
                    <xsl:value-of select="@image"/>
                </xsl:attribute>
            </img>
        </div>
    </xsl:template>

 </xsl:stylesheet>