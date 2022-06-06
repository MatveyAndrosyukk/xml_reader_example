<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
	<xsl:output method="xml" indent="yes"/>

	<xsl:template match="/">
		<xsl:text>&#xa;</xsl:text>
		<Hotels>
			<xsl:apply-templates />
		</Hotels>
	</xsl:template>
	<xsl:template match="Hotels/Hotel">
		<xsl:if test="contains(Name, 'Hilton') and (contains(Address/State, 'New York') or contains(Address/State, 'NY'))">
			<Hotel>
				<xsl:attribute name="Price"><xsl:value-of select="@Price"/></xsl:attribute>
				<Name><xsl:value-of select="Name"/></Name>
				<Address>
					<xsl:apply-templates select="Address"/>
				</Address>
			</Hotel>
		</xsl:if>
	</xsl:template>
	<xsl:template match="Hotels/Hotel/Address">
		<AddressLine><xsl:value-of select="AddressLine"/></AddressLine>
		<City><xsl:value-of select="City"/></City>
		<Country><xsl:value-of select="Country"/></Country>
		<State><xsl:value-of select="State"/></State>
	</xsl:template>

	<xsl:template match="text()" />
</xsl:stylesheet>


