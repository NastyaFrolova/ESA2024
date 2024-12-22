<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/library">
        <html>
            <head>
                <title>Library - Authors and Books</title>
                <style>
                    body { font-family: Arial, sans-serif; }
                    h1, h3 { color: #333; }
                    table { width: 80%; border-collapse: collapse; margin: 20px 0; }
                    th, td { padding: 8px; text-align: left; border: 1px solid #ddd; }
                    th { background-color: #f2f2f2; }
                </style>
            </head>
            <body>
                <h1>Library - Authors and Books</h1>
                <xsl:apply-templates select="author"/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="author">
        <h3><xsl:value-of select="name"/> (Born: <xsl:value-of select="birthdate"/>)</h3>
        <table>
            <tr>
                <th>Book Title</th>
                <th>Publish Date</th>
            </tr>
            <xsl:apply-templates select="books/book"/>
        </table>
    </xsl:template>

    <xsl:template match="book">
        <tr>
            <td><xsl:value-of select="title"/></td>
            <td><xsl:value-of select="publishdate"/></td>
        </tr>
    </xsl:template>

</xsl:stylesheet>