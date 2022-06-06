<?xml version="1.0" encoding="UTF-8"?>
<html xsl:version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <body style="font-size:12pt">
        <h1 style="font-size:20pt">Hotels.xml</h1>

        <!--Hotels-->
        <div id="Hotels">
            <span>&lt;Hotels&gt;</span>

            <xsl:for-each select="Hotels/Hotel">
                <xsl:if test="contains(Name, 'Hilton') and (contains(Address/State, 'New York') or contains(Address/State, 'NY'))">
                    <!--Hotel-->
                    <div style="margin-left:25pt" id="Hotel">
                        <div>
                            <span>&lt;Hotel Price = "<xsl:value-of select="@Price"/>"&gt;
                            </span>
                        </div>

                        <!--Hotel -> Name-->
                        <div style="margin-left:25pt" id="Name">
                            <span>&lt;Name&gt;</span>
                            <xsl:value-of select="Name"/>
                            <span>&lt;/Name&gt;</span>
                        </div>
                        <!-- - - - - - - -->

                        <!--Hotel -> Address-->
                        <div id="Address">
                            <div style="margin-left:25pt">
                                <span>&lt;Address&gt;</span>
                            </div>

                            <div style="margin-left:25pt" id="Address">
                                <!--Hotel -> Address -> AddressLine-->
                                <div style="margin-left:25pt" id="AddressLine">
                                    <span>&lt;AddressLine&gt;</span>
                                    <xsl:value-of select="Address/AddressLine"/>
                                    <span>&lt;/AddressLine&gt;</span>
                                </div>
                                <!-- - - - - - - - - - - - - - - - -->
                                <!--Hotel -> Address -> City-->
                                <div style="margin-left:25pt" id="City">
                                    <span>&lt;City&gt;</span>
                                    <xsl:value-of select="Address/City"/>
                                    <span>&lt;/City&gt;</span>
                                </div>
                                <!-- - - - - - - - - - - - - - - - -->
                                <!--Hotel -> Address -> Country-->
                                <div style="margin-left:25pt" id="Country">
                                    <span>&lt;Country&gt;</span>
                                    <xsl:value-of select="Address/Country"/>
                                    <span>&lt;/Country&gt;</span>
                                </div>
                                <!-- - - - - - - - - - - - - - - - -->
                                <!--Hotel -> Address -> State-->
                                <div style="margin-left:25pt" id="State">
                                    <span>&lt;State&gt;</span>
                                    <xsl:value-of select="Address/State"/>
                                    <span>&lt;/State&gt;</span>
                                </div>
                                <!-- - - - - - - - - - - - - - - - -->
                            </div>

                            <div style="margin-left:25pt">
                                <span>&lt;/Address&gt;</span>
                            </div>
                        </div>
                        <!-- - - - - - - -  -->

                        <div>
                            <span>&lt;/Hotel&gt;</span>
                        </div>
                    </div>
                    <!-- - - -->
                </xsl:if>
            </xsl:for-each>

            <span>&lt;/Hotels&gt;</span>
        </div>
        <!-- - - -->
    </body>
</html>