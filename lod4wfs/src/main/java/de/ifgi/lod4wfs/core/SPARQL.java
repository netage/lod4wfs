package de.ifgi.lod4wfs.core;

/**
 * Default SPARQL Queries used in the system.
 * @author jones
 * @version 1.0
 * 
 */

public class SPARQL {
	
	
	public static String listFeaturePredicates = 
										" SELECT DISTINCT ?predicate (datatype(?object) AS ?dataType) " + GlobalSettings.crlf +
										" WHERE { GRAPH <PARAM_LAYER> { " + GlobalSettings.crlf +
										"        ?geometry ?predicate ?object . " + GlobalSettings.crlf +
										"		?geometry a <http://www.opengis.net/ont/geosparql/1.0#Feature>. " + GlobalSettings.crlf +
										"		} " +
										"		FILTER(?predicate != <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ) " + GlobalSettings.crlf +
										"		FILTER(?predicate != " + GlobalSettings.getFeatureConnector() + " ) " + GlobalSettings.crlf +
										" } " + GlobalSettings.crlf  ; 
	
	public static String listNamedGraphs =  
										    " SELECT ?graphName ?abstract ?keywords ?title ?wkt " + GlobalSettings.crlf +
											" WHERE { GRAPH ?graph { " + GlobalSettings.crlf + 
											"	?graphName " + GlobalSettings.getAbstractPredicate() + " ?abstract . " + GlobalSettings.crlf +
											"	?graphName " + GlobalSettings.getTitlePredicate() + " ?title . " + GlobalSettings.crlf +
											"	?graphName " + GlobalSettings.getKeywordsPredicate() + " ?keywords  . " + GlobalSettings.crlf +
											"	{ SELECT DISTINCT ?wkt WHERE { " + GlobalSettings.crlf +
											"		GRAPH ?graph {?geometry " + GlobalSettings.getGeometryPredicate() + " ?wkt} } LIMIT 1 }} " + GlobalSettings.crlf +
											" }" + GlobalSettings.crlf ;		
	
	public static String getFeatureType =   " SELECT ?wkt " + GlobalSettings.crlf +
											" WHERE { GRAPH <PARAM_LAYER> { " + GlobalSettings.crlf +
											" 	?geometry a " + GlobalSettings.getGeometryClass() + " . " + GlobalSettings.crlf +
											" 	?geometry " + GlobalSettings.getGeometryPredicate() + " ?wkt " + GlobalSettings.crlf +
											" }} LIMIT 1 " + GlobalSettings.crlf ;
			
}
