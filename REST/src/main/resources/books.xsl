<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h1>Books List</h1>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Publish Date</th>
                    </tr>
                    <xsl:for-each select="books/book">
                        <tr>
                            <td><xsl:value-of select="id"/></td>
                            <td><xsl:value-of select="title"/></td>
                            <td><xsl:value-of select="publish_date"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>