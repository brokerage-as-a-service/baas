package de.upb.dbis.astro.protocols

import java.util.Date
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.HashMap

class CallTrace {
	@Accessors Date timestamp;
	@Accessors String clientHost;
	@Accessors String method;
	@Accessors String url;
	@Accessors String statusCode;
	@Accessors String operationId;
	@Accessors HashMap<String, String> parameterValues = new HashMap<String, String>();
}