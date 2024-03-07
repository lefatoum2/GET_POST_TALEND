// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for ESB
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.

package projet_esb_adda.jrestrequestaddproduct_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: jRestRequestAddProduct Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class jRestRequestAddProduct implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "jRestRequestAddProduct";
	private final String projectName = "PROJET_ESB_ADDA";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					jRestRequestAddProduct.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(jRestRequestAddProduct.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tDBOutput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTRequest_2_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tXMLMap_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTResponse_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTRequest_2_Loop_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		tRESTRequest_2_In_error(exception, errorComponent, globalMap);

	}

	public void tRESTRequest_2_In_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTRequest_2_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tXMLMap_3_TXMLMAP_OUT_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		tXMLMap_3_TXMLMAP_IN_error(exception, errorComponent, globalMap);

	}

	public void tXMLMap_3_TXMLMAP_IN_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTRequest_2_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tRESTRequest_2_Loop_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	private boolean runInTalendEsbRuntimeContainer = false;

	public void setRunInTalendEsbRuntimeContainer(boolean flag) {
		runInTalendEsbRuntimeContainer = flag;
	}

	protected String restEndpoint;

	public void setRestEndpoint(String restEndpoint) {
		this.restEndpoint = restEndpoint;
	}

	public String getRestEndpoint() {
		return "http://localhost:8081/products";
	}

	private boolean runInDaemonMode = true;

	public void setRunInDaemonMode(boolean flag) {
		runInDaemonMode = flag;
	}

	private boolean restTalendJobAlreadyStarted = false;

	/**
	 * REST provider implementation
	 */
	@javax.ws.rs.Path("/")

	public static class RestServiceProviderImpl4TalendJob {

		@javax.ws.rs.core.Context
		private org.apache.cxf.jaxrs.ext.MessageContext messageContext;
		private final String setCookieHeader = "Set-Cookie";

		private final jRestRequestAddProduct job;

		public RestServiceProviderImpl4TalendJob(jRestRequestAddProduct job) {
			this.job = job;
		}

		private void populateRequestWithJobContext(java.util.Map<String, Object> requestGlobalMap,
				jRestRequestAddProduct job) {
			// pass job DataSources
			java.util.Map<String, routines.system.TalendDataSource> talendDataSources = (java.util.Map<String, routines.system.TalendDataSource>) job.globalMap
					.get(KEY_DB_DATASOURCES);
			if (null != talendDataSources) {
				java.util.Map<String, routines.system.TalendDataSource> restDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
				for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry : talendDataSources
						.entrySet()) {
					restDataSources.put(talendDataSourceEntry.getKey(),
							new routines.system.TalendDataSource(talendDataSourceEntry.getValue().getRawDataSource()));
				}
				requestGlobalMap.put(KEY_DB_DATASOURCES, restDataSources);
			}

			if (null != job.globalMap.get(KEY_DB_DATASOURCES_RAW)) {
				requestGlobalMap.put(KEY_DB_DATASOURCES_RAW, job.globalMap.get(KEY_DB_DATASOURCES_RAW));
			}

			// pass job shared connections
			requestGlobalMap.putAll(job.getSharedConnections4REST());

			// pass job concurrent map
			requestGlobalMap.put("concurrentHashMap", job.globalMap.get("concurrentHashMap"));

			requestGlobalMap.putAll(job.globalMap);
		}

		private void closePassedDataSourceConnections(java.util.Map<String, Object> requestGlobalMap) {
			// close connections in passed job DataSources
			try {
				java.util.Map<String, routines.system.TalendDataSource> restDataSources = (java.util.Map<String, routines.system.TalendDataSource>) requestGlobalMap
						.get(KEY_DB_DATASOURCES);
				if (null != restDataSources) {
					for (routines.system.TalendDataSource restDataSource : restDataSources.values()) {
						restDataSource.close();
					}
				}
			} catch (Throwable e) {
				e.printStackTrace(System.err);
			}
		}

		private javax.ws.rs.core.Response processRequest(java.util.Map<String, Object> request) {

			final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();

			try {
				globalMap.put("restRequest", request);

				populateRequestWithJobContext(globalMap, job);

				job.tRESTRequest_2_LoopProcess(globalMap);

				java.util.Map<String, Object> response = (java.util.Map<String, Object>) globalMap.get("restResponse");

				Object responseBody = null;
				Integer status = null;
				java.util.Map<String, String> headers = null;
				if (null != response) {
					Object dropJsonRootProp = response.get("drop.json.root.element");
					Boolean dropJsonRoot = (null == dropJsonRootProp) ? false : (Boolean) dropJsonRootProp;
					messageContext.put("drop.json.root.element", dropJsonRoot.toString());

					responseBody = response.get("BODY");
					status = (Integer) response.get("STATUS");
					headers = (java.util.Map<String, String>) response.get("HEADERS");
				}
				if (null == status) {
					status = (request.containsKey("STATUS")) ? (Integer) request.get("STATUS") : 404;
				}

				javax.ws.rs.core.Response.ResponseBuilder responseBuilder = javax.ws.rs.core.Response.status(status)
						.entity(responseBody);
				if (headers != null) {
					for (java.util.Map.Entry<String, String> header : headers.entrySet()) {
						if (header.getKey().equalsIgnoreCase(setCookieHeader)) {
							String cookies = header.getValue().trim();
							String cookiesList[] = cookies.split(";");

							for (String cookie : cookiesList) {
								String cookieTokens[] = cookie.trim().split("=");

								if (cookieTokens.length == 2) {

									String cookieName = cookieTokens[0].trim();
									String cookieValue = cookieTokens[1].trim();

									if (cookieName.length() > 0 && cookieValue.length() > 0) {
										javax.ws.rs.core.NewCookie newCookie = new javax.ws.rs.core.NewCookie(
												cookieName, cookieValue);
										responseBuilder.cookie(newCookie);
									}
								}
							}
						} else {
							responseBuilder.header(header.getKey(), header.getValue());
						}
					}
				}

				return responseBuilder.build();

			} catch (Throwable ex) {
				ex.printStackTrace();
				throw new javax.ws.rs.WebApplicationException(ex, 500);
			} finally {
				// close DB connections
				closePassedDataSourceConnections(globalMap);
			}
		}

		private javax.ws.rs.core.Response processStreamingResponseRequest(final java.util.Map<String, Object> request) {

			javax.ws.rs.core.StreamingOutput streamingOutput = new javax.ws.rs.core.StreamingOutput() {
				public void write(java.io.OutputStream output) {

					final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();

					try {
						globalMap.put("restResponseStream", output);

						globalMap.put("restRequest", request);

						populateRequestWithJobContext(globalMap, job);

						job.tRESTRequest_2_LoopProcess(globalMap);

						if (globalMap.containsKey("restResponseWrappingClosure")) {
							output.write(((String) globalMap.get("restResponseWrappingClosure")).getBytes());
						}
					} catch (Throwable ex) {
						ex.printStackTrace();
						throw new javax.ws.rs.WebApplicationException(ex, 500);
					} finally {
						// close DB connections
						closePassedDataSourceConnections(globalMap);
					}
				}
			};

			return javax.ws.rs.core.Response.ok().entity(streamingOutput).build();
		}

		@javax.ws.rs.POST()

		@javax.ws.rs.Path("/product")
		@javax.ws.rs.Consumes({ "application/xml", "text/xml" })
		@javax.ws.rs.Produces({ "application/xml", "text/xml", "application/json" })
		public javax.ws.rs.core.Response copyOfaddProduct(

				org.dom4j.Document body

		) {
			java.util.Map<String, Object> request_tRESTRequest_2 = new java.util.HashMap<String, Object>();
			request_tRESTRequest_2.put("VERB", "POST");
			request_tRESTRequest_2.put("OPERATION", "copyOfaddProduct");
			request_tRESTRequest_2.put("PATTERN", "/product");

			request_tRESTRequest_2.put("BODY", body);

			populateRequestInfo(request_tRESTRequest_2, messageContext);

			java.util.Map<String, Object> parameters_tRESTRequest_2 = new java.util.HashMap<String, Object>();

			request_tRESTRequest_2.put("PARAMS", parameters_tRESTRequest_2);

			return processRequest(request_tRESTRequest_2);
		}

		public javax.ws.rs.core.Response handleWrongRequest(org.apache.cxf.jaxrs.ext.MessageContext context, int status,
				String error) {

			// System.out.println("wrong call [uri: " + context.getUriInfo().getPath() + " ;
			// method: " + context.getRequest().getMethod() + " ; status: " + status + " ;
			// error: " + error + "]");

			java.util.Map<String, Object> wrongRequest = new java.util.HashMap<String, Object>();

			wrongRequest.put("ERROR", error);
			wrongRequest.put("STATUS", status);
			wrongRequest.put("VERB", context.getRequest().getMethod());
			wrongRequest.put("URI", context.getUriInfo().getPath());
			wrongRequest.put("URI_BASE", context.getUriInfo().getBaseUri().toString());
			wrongRequest.put("URI_ABSOLUTE", context.getUriInfo().getAbsolutePath().toString());
			wrongRequest.put("URI_REQUEST", context.getUriInfo().getRequestUri().toString());

			return processRequest(wrongRequest);
		}

		private void populateRequestInfo(java.util.Map<String, Object> request,
				org.apache.cxf.jaxrs.ext.MessageContext context) {
			final javax.ws.rs.core.UriInfo ui = context.getUriInfo();

			request.put("URI", ui.getPath());
			request.put("URI_BASE", ui.getBaseUri().toString());
			request.put("URI_ABSOLUTE", ui.getAbsolutePath().toString());
			request.put("URI_REQUEST", ui.getRequestUri().toString());

			request.put("ALL_HEADER_PARAMS", context.getHttpHeaders().getRequestHeaders());
			request.put("ALL_QUERY_PARAMS", ui.getQueryParameters());

			javax.ws.rs.core.SecurityContext securityContext = context.getSecurityContext();
			if (null != securityContext && null != securityContext.getUserPrincipal()) {
				request.put("PRINCIPAL_NAME", securityContext.getUserPrincipal().getName());
			}

			request.put("CorrelationID", context.get("CorrelationID"));

			request.put("MESSAGE_CONTEXT", context);
		}

		private void populateMultipartRequestInfo(java.util.Map<String, Object> request,
				org.apache.cxf.jaxrs.ext.MessageContext context, java.util.List<String> partNames) {
			java.util.Map<String, String> attachmentFilenames = new java.util.HashMap<String, String>();

			java.util.Map<String, java.util.Map<String, java.util.List<String>>> attachmentHeaders = new java.util.HashMap<String, java.util.Map<String, java.util.List<String>>>();

			for (String partName : partNames) {
				org.apache.cxf.jaxrs.ext.multipart.Attachment attachment = getFirstMatchingPart(context, partName);
				if (null != attachment) {
					attachmentHeaders.put(partName, attachment.getHeaders());
					if (null != attachment.getContentDisposition()) {
						String filename = attachment.getContentDisposition().getParameter("filename");
						if (null != filename) {
							attachmentFilenames.put(partName, filename);
						}
					}
				}
			}

			request.put("ATTACHMENT_HEADERS", attachmentHeaders);
			request.put("ATTACHMENT_FILENAMES", attachmentFilenames);
		}

		private static org.apache.cxf.jaxrs.ext.multipart.Attachment getFirstMatchingPart(
				org.apache.cxf.jaxrs.ext.MessageContext context, String partName) {
			List<org.apache.cxf.jaxrs.ext.multipart.Attachment> attachments = org.apache.cxf.jaxrs.utils.multipart.AttachmentUtils
					.getAttachments(context);
			for (org.apache.cxf.jaxrs.ext.multipart.Attachment attachment : attachments) {
				if (partName.equals(attachment.getContentId())) {
					return attachment;
				}
				org.apache.cxf.jaxrs.ext.multipart.ContentDisposition cd = attachment.getContentDisposition();
				if (null != cd && partName.equals(cd.getParameter("name"))) {
					return attachment;
				}
			}
			// unexpected
			throw new javax.ws.rs.InternalServerErrorException();
		}
	}

	public static class ExceptionMapper4TalendJobRestService
			extends org.apache.cxf.jaxrs.impl.WebApplicationExceptionMapper {

		@javax.ws.rs.core.Context
		private org.apache.cxf.jaxrs.ext.MessageContext messageContext;

		private RestServiceProviderImpl4TalendJob provider;

		public ExceptionMapper4TalendJobRestService(RestServiceProviderImpl4TalendJob provider) {
			this.provider = provider;
		}

		public javax.ws.rs.core.Response toResponse(javax.ws.rs.WebApplicationException ex) {
			String error = null;
			javax.ws.rs.core.Response response = ex.getResponse();
			if (null != response && null != response.getEntity()) {
				error = response.getEntity().toString();
			}
			response = super.toResponse(ex);
			if (null == error) {
				if (null != response && null != response.getEntity()) {
					error = response.getEntity().toString();
				} else {
					error = null == ex.getCause() ? ex.getMessage() : ex.getCause().getMessage();
				}
			}
			response = provider.handleWrongRequest(messageContext, response.getStatus(), error);

			java.util.List<javax.ws.rs.core.MediaType> accepts = messageContext.getHttpHeaders()
					.getAcceptableMediaTypes();
			javax.ws.rs.core.MediaType responseType = accepts.isEmpty() ? null : accepts.get(0);

			if (responseType == null
					|| !responseType.getSubtype().equals("xml") && !responseType.getSubtype().equals("json")) {
				responseType = javax.ws.rs.core.MediaType.APPLICATION_XML_TYPE;
			}

			javax.ws.rs.core.Response r = javax.ws.rs.core.Response.status(response.getStatus())
					.entity(response.getEntity()).type(responseType).build();

			if (response.getHeaders() != null) {
				r.getHeaders().putAll(response.getHeaders());
			}

			return r;
		}
	}

	protected String checkEndpointUrl(String url) {
		final String defaultEndpointUrl = "http://127.0.0.1:8090/";

		String endpointUrl = url;
		if (null == endpointUrl || endpointUrl.trim().isEmpty()) {
			endpointUrl = defaultEndpointUrl;
		} else if (!endpointUrl.contains("://")) { // relative
			if (endpointUrl.startsWith("/")) {
				endpointUrl = endpointUrl.substring(1);
			}
			endpointUrl = defaultEndpointUrl + endpointUrl;
		}

		// test for busy
		java.net.URI endpointURI = java.net.URI.create(endpointUrl);
		String host = endpointURI.getHost();
		try {
			if (java.net.InetAddress.getByName(host).isLoopbackAddress()) {
				int port = endpointURI.getPort();
				java.net.ServerSocket ss = null;
				try {
					ss = new java.net.ServerSocket(port);
				} catch (IOException e) {
					// rethrow exception
					throw new IllegalArgumentException(
							"Cannot start provider with uri: " + endpointUrl + ". Port " + port + " already in use.");
				} finally {
					if (ss != null) {
						try {
							ss.close();
						} catch (IOException e) {
							// ignore
						}
					}
				}
				try {
					// ok, let's doublecheck for silent listeners
					java.net.Socket cs = new java.net.Socket(host, port);
					// if succeed - somebody silently listening, fail!
					cs.close();
					// rethrow exception
					throw new IllegalArgumentException(
							"Cannot start provider with uri: " + endpointUrl + ". Port " + port + " already in use.");
				} catch (IOException e) {
					// ok, nobody listens, proceed
				}
			}
		} catch (java.net.UnknownHostException e) {
			// ignore
		}

		return endpointUrl;
	}

	public static class StreamingDOM4JProvider extends org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider {

		public static final String SUPRESS_XML_DECLARATION = "supress.xml.declaration";

		private java.util.Map<String, Object> globalMap = null;

		public void setGlobalMap(java.util.Map<String, Object> globalMap) {
			this.globalMap = globalMap;
		}

		public void writeTo(org.dom4j.Document doc, Class<?> cls, java.lang.reflect.Type type,
				java.lang.annotation.Annotation[] anns, javax.ws.rs.core.MediaType mt,
				javax.ws.rs.core.MultivaluedMap<String, Object> headers, java.io.OutputStream os)
				throws java.io.IOException, javax.ws.rs.WebApplicationException {
			if (mt.getSubtype().contains("xml")) {
				org.dom4j.io.XMLWriter writer;
				org.apache.cxf.message.Message currentMessage = null;
				if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
					currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
				} else {
					currentMessage = (org.apache.cxf.message.Message) ((java.util.Map<String, Object>) globalMap
							.get("restRequest")).get("CURRENT_MESSAGE");
				}

				if (currentMessage != null && currentMessage.getExchange() != null
						&& currentMessage.getExchange().containsKey(SUPRESS_XML_DECLARATION)) {
					org.dom4j.io.OutputFormat format = new org.dom4j.io.OutputFormat();
					format.setSuppressDeclaration(true);
					writer = new org.dom4j.io.XMLWriter(os, format);
				} else {
					writer = new org.dom4j.io.XMLWriter(os);
				}
				writer.write(doc);
				writer.flush();
			} else {
				super.writeTo(doc, cls, type, anns, mt, headers, os);
			}
		}
	}

	Thread4RestServiceProviderEndpoint thread4RestServiceProviderEndpoint = null;

	class Thread4RestServiceProviderEndpoint extends Thread {

		private final String endpointUrl;

		private final jRestRequestAddProduct job;

		private org.apache.cxf.endpoint.Server server;

		private org.apache.cxf.jaxrs.JAXRSServerFactoryBean sf;

		public Thread4RestServiceProviderEndpoint(jRestRequestAddProduct job, String endpointUrl) {
			this.job = job;
			this.endpointUrl = endpointUrl;
			this.sf = new org.apache.cxf.jaxrs.JAXRSServerFactoryBean();
		}

		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		public org.apache.cxf.endpoint.Server getServer() {
			return server;
		}

		public org.apache.cxf.jaxrs.JAXRSServerFactoryBean getJAXRSServerFactoryBean() {
			return sf;
		}

		public void run() {

			try {
				RestServiceProviderImpl4TalendJob provider = new RestServiceProviderImpl4TalendJob(job);

				if (sf.getProperties() == null) {
					sf.setProperties(new java.util.HashMap<String, Object>());
				}

				java.util.List<Object> providers = (java.util.List<Object>) sf.getProviders();
				providers.add(new ExceptionMapper4TalendJobRestService(provider));
				providers.add(new StreamingDOM4JProvider());

				org.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider = new org.apache.cxf.jaxrs.provider.json.JSONProvider();
				jsonProvider.setIgnoreNamespaces(true);

				jsonProvider.setAttributesToElements(true);

				jsonProvider.setConvertTypesToStrings(false);

				providers.add(jsonProvider);
				sf.setProviders(providers);
				sf.setTransportId("http://cxf.apache.org/transports/http");
				sf.setResourceClasses(RestServiceProviderImpl4TalendJob.class);
				sf.setResourceProvider(RestServiceProviderImpl4TalendJob.class,
						new org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider(provider));
				sf.setAddress(endpointUrl);

				final java.util.List<org.apache.cxf.feature.Feature> features = sf.getFeatures() == null
						? new java.util.ArrayList<org.apache.cxf.feature.Feature>()
						: sf.getFeatures();

				sf.setFeatures(features);

				server = sf.create();

				// System.out.println("REST service [endpoint: " + endpointUrl + "] published");
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		public void stopEndpoint() {
			if (null != server) {
				server.stop();
				server.destroy();
				// System.out.println("REST service [endpoint: " + endpointUrl + "]
				// unpublished");
			}
		}
	}

	public static class ContextBean {
		static String evaluate(String context, String contextExpression)
				throws IOException, javax.script.ScriptException {
			boolean isExpression = contextExpression.contains("+") || contextExpression.contains("(");
			final String prefix = isExpression ? "\"" : "";
			java.util.Properties defaultProps = new java.util.Properties();
			java.io.InputStream inContext = jRestRequestAddProduct.class.getClassLoader().getResourceAsStream(
					"projet_esb_adda/jrestrequestaddproduct_0_1/contexts/" + context + ".properties");
			if (inContext == null) {
				inContext = jRestRequestAddProduct.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + context + ".properties");
			}
			try {
				defaultProps.load(inContext);
			} finally {
				inContext.close();
			}
			java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("context.([\\w]+)");
			java.util.regex.Matcher matcher = pattern.matcher(contextExpression);

			while (matcher.find()) {
				contextExpression = contextExpression.replaceAll(matcher.group(0),
						prefix + defaultProps.getProperty(matcher.group(1)) + prefix);
			}
			if (contextExpression.startsWith("/services")) {
				contextExpression = contextExpression.replaceFirst("/services", "");
			}
			return isExpression ? evaluateContextExpression(contextExpression) : contextExpression;
		}

		public static String evaluateContextExpression(String expression) throws javax.script.ScriptException {
			javax.script.ScriptEngineManager manager = new javax.script.ScriptEngineManager();
			javax.script.ScriptEngine engine = manager.getEngineByName("nashorn");
			// Add some import for Java
			expression = expression.replaceAll("System.getProperty", "java.lang.System.getProperty");
			return engine.eval(expression).toString();
		}

		public static String getContext(String context, String contextName, String jobName) throws Exception {

			String currentContext = null;
			String jobNameStripped = jobName.substring(jobName.lastIndexOf(".") + 1);

			boolean inOSGi = routines.system.BundleUtils.inOSGi();

			if (inOSGi) {
				java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils
						.getJobProperties(jobNameStripped);

				if (jobProperties != null) {
					currentContext = (String) jobProperties.get("context");
				}
			}

			return contextName.contains("context.")
					? evaluate(currentContext == null ? context : currentContext, contextName)
					: contextName;
		}
	}

	public static class copyOfResponseStruct implements routines.system.IPersistableRow<copyOfResponseStruct> {
		final static byte[] commonByteArrayLock_PROJET_ESB_ADDA_jRestRequestAddProduct = new byte[0];
		static byte[] commonByteArray_PROJET_ESB_ADDA_jRestRequestAddProduct = new byte[0];

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJET_ESB_ADDA_jRestRequestAddProduct) {

				try {

					int length = 0;

					this.body = (routines.system.Document) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJET_ESB_ADDA_jRestRequestAddProduct) {

				try {

					int length = 0;

					this.body = (routines.system.Document) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Document

				dos.writeObject(this.body);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Document

				dos.writeObject(this.body);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("body=" + String.valueOf(body));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(copyOfResponseStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_PROJET_ESB_ADDA_jRestRequestAddProduct = new byte[0];
		static byte[] commonByteArray_PROJET_ESB_ADDA_jRestRequestAddProduct = new byte[0];

		public Integer NB_LINE;

		public Integer getNB_LINE() {
			return this.NB_LINE;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJET_ESB_ADDA_jRestRequestAddProduct) {

				try {

					int length = 0;

					this.NB_LINE = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJET_ESB_ADDA_jRestRequestAddProduct) {

				try {

					int length = 0;

					this.NB_LINE = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.NB_LINE, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.NB_LINE, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("NB_LINE=" + String.valueOf(NB_LINE));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFixedFlowInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFixedFlowInput_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row2Struct row2 = new row2Struct();
				copyOfResponseStruct copyOfResponse = new copyOfResponseStruct();

				/**
				 * [tRESTResponse_2 begin ] start
				 */

				ok_Hash.put("tRESTResponse_2", false);
				start_Hash.put("tRESTResponse_2", System.currentTimeMillis());

				currentComponent = "tRESTResponse_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "copyOfResponse");
				}

				int tos_count_tRESTResponse_2 = 0;

				/**
				 * [tRESTResponse_2 begin ] stop
				 */

				/**
				 * [tXMLMap_4 begin ] start
				 */

				ok_Hash.put("tXMLMap_4", false);
				start_Hash.put("tXMLMap_4", System.currentTimeMillis());

				currentComponent = "tXMLMap_4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
				}

				int tos_count_tXMLMap_4 = 0;

//===============================input xml init part===============================
				class XML_API_tXMLMap_4 {
					public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						if (node != null && node instanceof org.dom4j.Element) {
							org.dom4j.Attribute attri = ((org.dom4j.Element) node).attribute("nil");
							if (attri != null && ("true").equals(attri.getText())) {
								return true;
							}
						}
						return false;
					}

					public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						return node == null ? true : false;
					}

					public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						if (node != null) {
							return node.getText().length() == 0;
						}
						return false;
					}
				}
				class Var__tXMLMap_4__Struct {
				}
				Var__tXMLMap_4__Struct Var__tXMLMap_4 = new Var__tXMLMap_4__Struct();
// ###############################
// # Outputs initialization
				copyOfResponseStruct copyOfResponse_tmp = new copyOfResponseStruct();
				copyOfResponseStruct copyOfResponse_save = null;
// ###############################
				int nb_line_tXMLMap_4 = 0;

				XML_API_tXMLMap_4 xml_api_tXMLMap_4 = new XML_API_tXMLMap_4();

				class GenerateDocument_copyOfResponse {

					java.util.Map<String, Object> valueMap = null;

					routines.system.DocumentGenerateOrderHelper orderHelper = new routines.system.DocumentGenerateOrderHelper(
							1);

					org.dom4j.Document doc = null;

					org.dom4j.Element root4Group = null;

					org.dom4j.io.OutputFormat format = null;

					java.util.List<java.util.List<String>> groupbyList = null;
					java.util.List<org.dom4j.Element> groupElementList = null;
					int order = 0;

					boolean isFirst = true;

					boolean needRoot = true;

					String currentValue = null;

					public GenerateDocument_copyOfResponse() {
//    	this.treeNodeAPI = treeNodeAPI;

						valueMap = new java.util.HashMap<String, Object>();

						groupbyList = new java.util.ArrayList<java.util.List<String>>();
						groupElementList = new java.util.ArrayList<org.dom4j.Element>();

						doc = org.dom4j.DocumentHelper.createDocument();
						format = org.dom4j.io.OutputFormat.createPrettyPrint();
						format.setTrimText(false);
					}

					public org.dom4j.Document getDocument() {
						generateOk();
						return this.doc;
					}

					// do some work after document has been generated
					private void generateOk() {
						routines.system.NestXMLTool.replaceDefaultNameSpace(this.doc.getRootElement(), null);
					}

					// We generate the TreeNode_API object only if there is a document in the main
					// input table.
					void generateElements(boolean isInnerJoin, row2Struct row2, Var__tXMLMap_4__Struct Var) {

						/*
						 * if(this.treeNodeAPI==null) { this.treeNodeAPI = treeNodeAPI; }
						 */

						org.dom4j.Element subTreeRootParent = null;
// build root xml tree 
						if (needRoot) {
							needRoot = false;
							org.dom4j.Element root = null;
							root = org.dom4j.DocumentHelper.createElement("root");
							doc.add(root);
							subTreeRootParent = root;
							valueMap.put("root", "Nombre de lignes insérées" + row2.NB_LINE);
							if (valueMap.get("root") != null) {
								routines.system.NestXMLTool.setText(root,
										FormatterUtils.fm(valueMap.get("root"), null));
							}
							root4Group = subTreeRootParent;
						} else {
							subTreeRootParent = root4Group;
						}
						/* build group xml tree */
						boolean isNewElement = false;
						isNewElement = false;
					}
				}

				/**
				 * [tXMLMap_4 begin ] stop
				 */

				/**
				 * [tFixedFlowInput_2 begin ] start
				 */

				ok_Hash.put("tFixedFlowInput_2", false);
				start_Hash.put("tFixedFlowInput_2", System.currentTimeMillis());

				currentComponent = "tFixedFlowInput_2";

				int tos_count_tFixedFlowInput_2 = 0;

				for (int i_tFixedFlowInput_2 = 0; i_tFixedFlowInput_2 < 1; i_tFixedFlowInput_2++) {

					row2.NB_LINE = ((Integer) globalMap.get("tDBOutput_2_NB_LINE_INSERTED"));

					/**
					 * [tFixedFlowInput_2 begin ] stop
					 */

					/**
					 * [tFixedFlowInput_2 main ] start
					 */

					currentComponent = "tFixedFlowInput_2";

					tos_count_tFixedFlowInput_2++;

					/**
					 * [tFixedFlowInput_2 main ] stop
					 */

					/**
					 * [tFixedFlowInput_2 process_data_begin ] start
					 */

					currentComponent = "tFixedFlowInput_2";

					/**
					 * [tFixedFlowInput_2 process_data_begin ] stop
					 */

					/**
					 * [tXMLMap_4 main ] start
					 */

					currentComponent = "tXMLMap_4";

					if (execStat) {
						runStat.updateStatOnConnection(iterateId, 1, 1

								, "row2"

						);
					}

					boolean rejectedInnerJoin_tXMLMap_4 = false;
					boolean rejectedDocInnerJoin_tXMLMap_4 = false;
					boolean mainRowRejected_tXMLMap_4 = false;
					boolean isMatchDocRowtXMLMap_4 = false;

					GenerateDocument_copyOfResponse gen_Doc_copyOfResponse_tXMLMap_4 = new GenerateDocument_copyOfResponse();
					copyOfResponse_tmp.body = null;

					{ // start of Var scope

						// ###############################
						// # Vars tables

						Var__tXMLMap_4__Struct Var = Var__tXMLMap_4;
						// ###############################
						// # Output tables

						copyOfResponse = null;

// # Output table : 'copyOfResponse'

						gen_Doc_copyOfResponse_tXMLMap_4.generateElements(rejectedDocInnerJoin_tXMLMap_4, row2, Var);

						if (copyOfResponse_tmp.body == null) {
							copyOfResponse_tmp.body = new routines.system.Document();
							copyOfResponse_tmp.body.setDocument(gen_Doc_copyOfResponse_tXMLMap_4.getDocument());
						}

						copyOfResponse = copyOfResponse_tmp;
						copyOfResponse_save = copyOfResponse_tmp;
// ###############################

					} // end of Var scope

					rejectedInnerJoin_tXMLMap_4 = false;

					tos_count_tXMLMap_4++;

					/**
					 * [tXMLMap_4 main ] stop
					 */

					/**
					 * [tXMLMap_4 process_data_begin ] start
					 */

					currentComponent = "tXMLMap_4";

					/**
					 * [tXMLMap_4 process_data_begin ] stop
					 */
// Start of branch "copyOfResponse"
					if (copyOfResponse != null) {

						/**
						 * [tRESTResponse_2 main ] start
						 */

						currentComponent = "tRESTResponse_2";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "copyOfResponse"

							);
						}

						java.io.OutputStream outputStream_tRESTResponse_2 = (java.io.OutputStream) globalMap
								.get("restResponseStream");
						boolean responseAlreadySent_tRESTResponse_2 = globalMap.containsKey("restResponse");

						if (null == outputStream_tRESTResponse_2 && responseAlreadySent_tRESTResponse_2) {
							throw new RuntimeException("Rest response already sent.");
						} else if (!globalMap.containsKey("restRequest")) {
							throw new RuntimeException("Not received rest request yet.");
						} else {
							Integer restProviderStatusCode_tRESTResponse_2 = 200;

							Object restProviderResponse_tRESTResponse_2 = null;
							if (null != copyOfResponse.body) {
								restProviderResponse_tRESTResponse_2 = copyOfResponse.body.getDocument();
							}

							java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_2 = new java.util.TreeMap<String, String>(
									String.CASE_INSENSITIVE_ORDER);
							java.lang.StringBuilder restProviderResponseHeader_cookies_tRESTResponse_2 = new java.lang.StringBuilder();
							final String setCookieHeader = "Set-Cookie";

							if (restProviderResponseHeader_cookies_tRESTResponse_2.length() > 0) {
								restProviderResponseHeaders_tRESTResponse_2.put(setCookieHeader,
										restProviderResponseHeader_cookies_tRESTResponse_2.toString());
							}

							java.util.Map<String, Object> restRequest_tRESTResponse_2 = (java.util.Map<String, Object>) globalMap
									.get("restRequest");
							org.apache.cxf.jaxrs.ext.MessageContext messageContext_tRESTResponse_2 = (org.apache.cxf.jaxrs.ext.MessageContext) restRequest_tRESTResponse_2
									.get("MESSAGE_CONTEXT");

							if (null == outputStream_tRESTResponse_2) {
								java.util.Map<String, Object> restResponse_tRESTResponse_2 = new java.util.HashMap<String, Object>();
								restResponse_tRESTResponse_2.put("BODY", restProviderResponse_tRESTResponse_2);
								restResponse_tRESTResponse_2.put("STATUS", restProviderStatusCode_tRESTResponse_2);
								restResponse_tRESTResponse_2.put("HEADERS",
										restProviderResponseHeaders_tRESTResponse_2);
								restResponse_tRESTResponse_2.put("drop.json.root.element", Boolean.valueOf(false));
								globalMap.put("restResponse", restResponse_tRESTResponse_2);

							} else {

								javax.ws.rs.core.MediaType responseMediaType_tRESTResponse_2 = null;
								if (!responseAlreadySent_tRESTResponse_2) {
									org.apache.cxf.message.Message currentMessage = null;
									if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
										currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
									} else {
										currentMessage = ((org.apache.cxf.message.Message) restRequest_tRESTResponse_2
												.get("CURRENT_MESSAGE"));
									}

									if (currentMessage != null && currentMessage.getExchange() != null) {
										currentMessage.getExchange().put(StreamingDOM4JProvider.SUPRESS_XML_DECLARATION,
												true);
									}

									messageContext_tRESTResponse_2.put(org.apache.cxf.message.Message.RESPONSE_CODE,
											restProviderStatusCode_tRESTResponse_2);
									javax.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_2 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
									for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_2
											.entrySet()) {
										headersMultivaluedMap_tRESTResponse_2.putSingle(multivaluedHeader.getKey(),
												multivaluedHeader.getValue());
									}
									messageContext_tRESTResponse_2.put(org.apache.cxf.message.Message.PROTOCOL_HEADERS,
											headersMultivaluedMap_tRESTResponse_2);

									String responseContentType_tRESTResponse_2 = null;

									if (currentMessage != null && currentMessage.getExchange() != null) {
										responseContentType_tRESTResponse_2 = (String) currentMessage.getExchange()
												.get(org.apache.cxf.message.Message.CONTENT_TYPE);
									}

									if (null == responseContentType_tRESTResponse_2) {
										// this should not be needed, just in case. set it to the first value in the
										// sorted list returned from HttpHeaders
										responseMediaType_tRESTResponse_2 = messageContext_tRESTResponse_2
												.getHttpHeaders().getAcceptableMediaTypes().get(0);
									} else {
										responseMediaType_tRESTResponse_2 = org.apache.cxf.jaxrs.utils.JAXRSUtils
												.toMediaType(responseContentType_tRESTResponse_2);
									}
									globalMap.put("restResponseMediaType", responseMediaType_tRESTResponse_2);

									String responseMediaSubType_tRESTResponse_2 = responseMediaType_tRESTResponse_2
											.getSubtype();
									if (responseMediaSubType_tRESTResponse_2.equals("xml")
											|| responseMediaSubType_tRESTResponse_2.endsWith("+xml")) {
										outputStream_tRESTResponse_2.write("<wrapper>".getBytes());
										globalMap.put("restResponseWrappingClosure", "</wrapper>");
									}
									if (responseMediaSubType_tRESTResponse_2.equals("json")
											|| responseMediaSubType_tRESTResponse_2.endsWith("+json")) {
										outputStream_tRESTResponse_2.write("[".getBytes());
										globalMap.put("restResponseWrappingClosure", "]");
									}

									globalMap.put("restResponse", true);
								} else {
									responseMediaType_tRESTResponse_2 = (javax.ws.rs.core.MediaType) globalMap
											.get("restResponseMediaType");
								}

								if (null != restProviderResponse_tRESTResponse_2) {
									String responseMediaSubType_tRESTResponse_2 = responseMediaType_tRESTResponse_2
											.getSubtype();
									if (responseMediaSubType_tRESTResponse_2.equals("json")
											|| responseMediaSubType_tRESTResponse_2.endsWith("+json")) {
										if (globalMap.containsKey("restResponseJsonStarted")) {
											outputStream_tRESTResponse_2.write(",".getBytes());
										} else {
											globalMap.put("restResponseJsonStarted", true);
										}
									}

									Class<? extends Object> responseBodyClass_tRESTResponse_2 = restProviderResponse_tRESTResponse_2
											.getClass();
									javax.ws.rs.ext.Providers messageBodyProviders_tRESTResponse_2 = messageContext_tRESTResponse_2
											.getProviders();
									javax.ws.rs.ext.MessageBodyWriter messageBodyWriter_tRESTResponse_2 = messageBodyProviders_tRESTResponse_2
											.getMessageBodyWriter(responseBodyClass_tRESTResponse_2,
													responseBodyClass_tRESTResponse_2, null,
													responseMediaType_tRESTResponse_2);

									if (messageBodyWriter_tRESTResponse_2 instanceof StreamingDOM4JProvider) {
										((StreamingDOM4JProvider) messageBodyWriter_tRESTResponse_2)
												.setGlobalMap(globalMap);
									}

									messageBodyWriter_tRESTResponse_2.writeTo(restProviderResponse_tRESTResponse_2,
											responseBodyClass_tRESTResponse_2, responseBodyClass_tRESTResponse_2,
											new java.lang.annotation.Annotation[] {}, responseMediaType_tRESTResponse_2,
											null, outputStream_tRESTResponse_2);
								}
								// initial variant
								// outputStream_tRESTResponse_2.write(String.valueOf(restProviderResponse_tRESTResponse_2).getBytes());
								outputStream_tRESTResponse_2.flush();
							}
						}

						tos_count_tRESTResponse_2++;

						/**
						 * [tRESTResponse_2 main ] stop
						 */

						/**
						 * [tRESTResponse_2 process_data_begin ] start
						 */

						currentComponent = "tRESTResponse_2";

						/**
						 * [tRESTResponse_2 process_data_begin ] stop
						 */

						/**
						 * [tRESTResponse_2 process_data_end ] start
						 */

						currentComponent = "tRESTResponse_2";

						/**
						 * [tRESTResponse_2 process_data_end ] stop
						 */

					} // End of branch "copyOfResponse"

					/**
					 * [tXMLMap_4 process_data_end ] start
					 */

					currentComponent = "tXMLMap_4";

					/**
					 * [tXMLMap_4 process_data_end ] stop
					 */

					/**
					 * [tFixedFlowInput_2 process_data_end ] start
					 */

					currentComponent = "tFixedFlowInput_2";

					/**
					 * [tFixedFlowInput_2 process_data_end ] stop
					 */

					/**
					 * [tFixedFlowInput_2 end ] start
					 */

					currentComponent = "tFixedFlowInput_2";

				}
				globalMap.put("tFixedFlowInput_2_NB_LINE", 1);

				ok_Hash.put("tFixedFlowInput_2", true);
				end_Hash.put("tFixedFlowInput_2", System.currentTimeMillis());

				/**
				 * [tFixedFlowInput_2 end ] stop
				 */

				/**
				 * [tXMLMap_4 end ] start
				 */

				currentComponent = "tXMLMap_4";

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
				}

				ok_Hash.put("tXMLMap_4", true);
				end_Hash.put("tXMLMap_4", System.currentTimeMillis());

				/**
				 * [tXMLMap_4 end ] stop
				 */

				/**
				 * [tRESTResponse_2 end ] start
				 */

				currentComponent = "tRESTResponse_2";

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "copyOfResponse");
				}

				ok_Hash.put("tRESTResponse_2", true);
				end_Hash.put("tRESTResponse_2", System.currentTimeMillis());

				/**
				 * [tRESTResponse_2 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tFixedFlowInput_2 finally ] start
				 */

				currentComponent = "tFixedFlowInput_2";

				/**
				 * [tFixedFlowInput_2 finally ] stop
				 */

				/**
				 * [tXMLMap_4 finally ] start
				 */

				currentComponent = "tXMLMap_4";

				/**
				 * [tXMLMap_4 finally ] stop
				 */

				/**
				 * [tRESTResponse_2 finally ] start
				 */

				currentComponent = "tRESTResponse_2";

				/**
				 * [tRESTResponse_2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFixedFlowInput_2_SUBPROCESS_STATE", 1);
	}

	public static class copyOfaddProductsStruct implements routines.system.IPersistableRow<copyOfaddProductsStruct> {
		final static byte[] commonByteArrayLock_PROJET_ESB_ADDA_jRestRequestAddProduct = new byte[0];
		static byte[] commonByteArray_PROJET_ESB_ADDA_jRestRequestAddProduct = new byte[0];

		public String CD_PRODUIT;

		public String getCD_PRODUIT() {
			return this.CD_PRODUIT;
		}

		public String NOM_PRODUIT;

		public String getNOM_PRODUIT() {
			return this.NOM_PRODUIT;
		}

		public Float PRIX_ACHAT_PRODUIT;

		public Float getPRIX_ACHAT_PRODUIT() {
			return this.PRIX_ACHAT_PRODUIT;
		}

		public Float PRIX_VENTE_PRODUIT;

		public Float getPRIX_VENTE_PRODUIT() {
			return this.PRIX_VENTE_PRODUIT;
		}

		public String CD_SOUS_CATEGORIE;

		public String getCD_SOUS_CATEGORIE() {
			return this.CD_SOUS_CATEGORIE;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJET_ESB_ADDA_jRestRequestAddProduct.length) {
					if (length < 1024 && commonByteArray_PROJET_ESB_ADDA_jRestRequestAddProduct.length == 0) {
						commonByteArray_PROJET_ESB_ADDA_jRestRequestAddProduct = new byte[1024];
					} else {
						commonByteArray_PROJET_ESB_ADDA_jRestRequestAddProduct = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJET_ESB_ADDA_jRestRequestAddProduct, 0, length);
				strReturn = new String(commonByteArray_PROJET_ESB_ADDA_jRestRequestAddProduct, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJET_ESB_ADDA_jRestRequestAddProduct.length) {
					if (length < 1024 && commonByteArray_PROJET_ESB_ADDA_jRestRequestAddProduct.length == 0) {
						commonByteArray_PROJET_ESB_ADDA_jRestRequestAddProduct = new byte[1024];
					} else {
						commonByteArray_PROJET_ESB_ADDA_jRestRequestAddProduct = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PROJET_ESB_ADDA_jRestRequestAddProduct, 0, length);
				strReturn = new String(commonByteArray_PROJET_ESB_ADDA_jRestRequestAddProduct, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJET_ESB_ADDA_jRestRequestAddProduct) {

				try {

					int length = 0;

					this.CD_PRODUIT = readString(dis);

					this.NOM_PRODUIT = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.PRIX_ACHAT_PRODUIT = null;
					} else {
						this.PRIX_ACHAT_PRODUIT = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PRIX_VENTE_PRODUIT = null;
					} else {
						this.PRIX_VENTE_PRODUIT = dis.readFloat();
					}

					this.CD_SOUS_CATEGORIE = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJET_ESB_ADDA_jRestRequestAddProduct) {

				try {

					int length = 0;

					this.CD_PRODUIT = readString(dis);

					this.NOM_PRODUIT = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.PRIX_ACHAT_PRODUIT = null;
					} else {
						this.PRIX_ACHAT_PRODUIT = dis.readFloat();
					}

					length = dis.readByte();
					if (length == -1) {
						this.PRIX_VENTE_PRODUIT = null;
					} else {
						this.PRIX_VENTE_PRODUIT = dis.readFloat();
					}

					this.CD_SOUS_CATEGORIE = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.CD_PRODUIT, dos);

				// String

				writeString(this.NOM_PRODUIT, dos);

				// Float

				if (this.PRIX_ACHAT_PRODUIT == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PRIX_ACHAT_PRODUIT);
				}

				// Float

				if (this.PRIX_VENTE_PRODUIT == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PRIX_VENTE_PRODUIT);
				}

				// String

				writeString(this.CD_SOUS_CATEGORIE, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.CD_PRODUIT, dos);

				// String

				writeString(this.NOM_PRODUIT, dos);

				// Float

				if (this.PRIX_ACHAT_PRODUIT == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PRIX_ACHAT_PRODUIT);
				}

				// Float

				if (this.PRIX_VENTE_PRODUIT == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeFloat(this.PRIX_VENTE_PRODUIT);
				}

				// String

				writeString(this.CD_SOUS_CATEGORIE, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("CD_PRODUIT=" + CD_PRODUIT);
			sb.append(",NOM_PRODUIT=" + NOM_PRODUIT);
			sb.append(",PRIX_ACHAT_PRODUIT=" + String.valueOf(PRIX_ACHAT_PRODUIT));
			sb.append(",PRIX_VENTE_PRODUIT=" + String.valueOf(PRIX_VENTE_PRODUIT));
			sb.append(",CD_SOUS_CATEGORIE=" + CD_SOUS_CATEGORIE);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(copyOfaddProductsStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class copyOfaddProductStruct implements routines.system.IPersistableRow<copyOfaddProductStruct> {
		final static byte[] commonByteArrayLock_PROJET_ESB_ADDA_jRestRequestAddProduct = new byte[0];
		static byte[] commonByteArray_PROJET_ESB_ADDA_jRestRequestAddProduct = new byte[0];

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJET_ESB_ADDA_jRestRequestAddProduct) {

				try {

					int length = 0;

					this.body = (routines.system.Document) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJET_ESB_ADDA_jRestRequestAddProduct) {

				try {

					int length = 0;

					this.body = (routines.system.Document) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Document

				dos.writeObject(this.body);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Document

				dos.writeObject(this.body);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("body=" + String.valueOf(body));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(copyOfaddProductStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tRESTRequest_2_LoopProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRESTRequest_2_Loop_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;
		String currentVirtualComponent = null;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				copyOfaddProductStruct copyOfaddProduct = new copyOfaddProductStruct();
				copyOfaddProductsStruct copyOfaddProducts = new copyOfaddProductsStruct();

				/**
				 * [tRESTRequest_2_Loop begin ] start
				 */

				int NB_ITERATE_tRESTRequest_2_In = 0; // for statistics

				ok_Hash.put("tRESTRequest_2_Loop", false);
				start_Hash.put("tRESTRequest_2_Loop", System.currentTimeMillis());

				currentVirtualComponent = "tRESTRequest_2";

				currentComponent = "tRESTRequest_2_Loop";

				int tos_count_tRESTRequest_2_Loop = 0;

				if (execStat) {
					runStat.updateStatOnConnection(iterateId, 0, 0, "copyOfaddProduct", "copyOfaddProducts");
				}

				copyOfaddProduct = null;

				int nb_line_tRESTRequest_2 = 0;

				try {

					java.util.Map<String, Object> requestMessage_tRESTRequest_2 = (java.util.Map<String, Object>) globalMap
							.get("restRequest");

					restEndpoint = getRestEndpoint();

					if (null == requestMessage_tRESTRequest_2) {

						if (restTalendJobAlreadyStarted) {
							throw new RuntimeException("request is not provided");
						} else {
							if (!runInTalendEsbRuntimeContainer && null == thread4RestServiceProviderEndpoint) {
								String endpointUrl_tRESTRequest_2 = checkEndpointUrl(restEndpoint);
								// *** external thread for endpoint initialization
								thread4RestServiceProviderEndpoint = new Thread4RestServiceProviderEndpoint(this,
										endpointUrl_tRESTRequest_2);
								thread4RestServiceProviderEndpoint.start();
								// *** external thread for endpoint initialization
							}

							restTalendJobAlreadyStarted = true;

							if (runInDaemonMode) {
								Thread.currentThread();
								try {
									while (true) {
										Thread.sleep(60000);
									}
								} catch (InterruptedException e_tRESTRequest_2) {
									// e_tRESTRequest_2.printStackTrace();
									// throw new TalendException(e_tRESTRequest_2, "wholeJob", globalMap);
								}
							}
						}
						return;
					}

					requestMessage_tRESTRequest_2.put("CURRENT_MESSAGE",
							org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage());

					Object ctx_tRESTRequest_2 = requestMessage_tRESTRequest_2.get("MESSAGE_CONTEXT");
					if (ctx_tRESTRequest_2 != null
							&& ctx_tRESTRequest_2 instanceof org.apache.cxf.jaxrs.impl.tl.ThreadLocalMessageContext) {
						requestMessage_tRESTRequest_2.put("MESSAGE_CONTEXT",
								((org.apache.cxf.jaxrs.impl.tl.ThreadLocalMessageContext) ctx_tRESTRequest_2).get());
					}

					/**
					 * [tRESTRequest_2_Loop begin ] stop
					 */

					/**
					 * [tRESTRequest_2_Loop main ] start
					 */

					currentVirtualComponent = "tRESTRequest_2";

					currentComponent = "tRESTRequest_2_Loop";

					resourceMap.put("inIterateVComp", true);

					tos_count_tRESTRequest_2_Loop++;

					/**
					 * [tRESTRequest_2_Loop main ] stop
					 */

					/**
					 * [tRESTRequest_2_Loop process_data_begin ] start
					 */

					currentVirtualComponent = "tRESTRequest_2";

					currentComponent = "tRESTRequest_2_Loop";

					/**
					 * [tRESTRequest_2_Loop process_data_begin ] stop
					 */
					NB_ITERATE_tRESTRequest_2_In++;

					if (execStat) {
						runStat.updateStatOnConnection("Iterate", 1, "exec" + NB_ITERATE_tRESTRequest_2_In);
						// Thread.sleep(1000);
					}

					/**
					 * [tXMLMap_3_TXMLMAP_OUT begin ] start
					 */

					ok_Hash.put("tXMLMap_3_TXMLMAP_OUT", false);
					start_Hash.put("tXMLMap_3_TXMLMAP_OUT", System.currentTimeMillis());

					currentVirtualComponent = "tXMLMap_3";

					currentComponent = "tXMLMap_3_TXMLMAP_OUT";

					if (execStat) {
						runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "copyOfaddProduct");
					}

					int tos_count_tXMLMap_3_TXMLMAP_OUT = 0;

//===============================input xml init part===============================
					class XML_API_tXMLMap_3_TXMLMAP_OUT {
						public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
							if (node != null && node instanceof org.dom4j.Element) {
								org.dom4j.Attribute attri = ((org.dom4j.Element) node).attribute("nil");
								if (attri != null && ("true").equals(attri.getText())) {
									return true;
								}
							}
							return false;
						}

						public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
							return node == null ? true : false;
						}

						public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
							if (node != null) {
								return node.getText().length() == 0;
							}
							return false;
						}
					}
					class Var__tXMLMap_3_TXMLMAP_OUT__Struct {
					}
					Var__tXMLMap_3_TXMLMAP_OUT__Struct Var__tXMLMap_3_TXMLMAP_OUT = new Var__tXMLMap_3_TXMLMAP_OUT__Struct();
// ###############################
// # Outputs initialization
					copyOfaddProductsStruct copyOfaddProducts_tmp = new copyOfaddProductsStruct();
					copyOfaddProductsStruct copyOfaddProducts_save = null;
//the aggregate variable
					copyOfaddProductsStruct copyOfaddProducts_aggregate = null;
//init the resultset for aggregate
					java.util.List<Object> allOutsForAggregate_tXMLMap_3 = new java.util.ArrayList<Object>();
					globalMap.put("allOutsForAggregate_tXMLMap_3", allOutsForAggregate_tXMLMap_3);
// ###############################
					class TreeNode_API_tXMLMap_3_TXMLMAP_OUT {
						java.util.Map<String, String> xpath_value_map = new java.util.HashMap<String, String>();

						void clear() {
							xpath_value_map.clear();
						}

						void put(String xpath, String value) {
							xpath_value_map.put(xpath, value);
						}

						String get_null(String xpath) {
							return null;
						}

						String get_String(String xpath) {
							return xpath_value_map.get(xpath);
						}

						Float get_Float(String xpath) {
							String content = xpath_value_map.get(xpath);
							if (content == null || content.length() == 0)
								return null;
							return ParserUtils.parseTo_Float(content);
						}
					}
					TreeNode_API_tXMLMap_3_TXMLMAP_OUT treeNodeAPI_tXMLMap_3_TXMLMAP_OUT = new TreeNode_API_tXMLMap_3_TXMLMAP_OUT();
					NameSpaceTool nsTool_tXMLMap_3_TXMLMAP_OUT = new NameSpaceTool();
					int nb_line_tXMLMap_3_TXMLMAP_OUT = 0;

					XML_API_tXMLMap_3_TXMLMAP_OUT xml_api_tXMLMap_3_TXMLMAP_OUT = new XML_API_tXMLMap_3_TXMLMAP_OUT();

					// the map store the previous value of aggregate columns
					java.util.Map<String, Object> aggregateCacheMap_tXMLMap_3_TXMLMAP_OUT = new java.util.HashMap<String, Object>();

					/**
					 * [tXMLMap_3_TXMLMAP_OUT begin ] stop
					 */

					/**
					 * [tRESTRequest_2_In begin ] start
					 */

					ok_Hash.put("tRESTRequest_2_In", false);
					start_Hash.put("tRESTRequest_2_In", System.currentTimeMillis());

					currentVirtualComponent = "tRESTRequest_2";

					currentComponent = "tRESTRequest_2_In";

					int tos_count_tRESTRequest_2_In = 0;

					resourceMap.remove("inIterateVComp");

					/**
					 * [tRESTRequest_2_In begin ] stop
					 */

					/**
					 * [tRESTRequest_2_In main ] start
					 */

					currentVirtualComponent = "tRESTRequest_2";

					currentComponent = "tRESTRequest_2_In";

					if (requestMessage_tRESTRequest_2.containsKey("ERROR")) { // wrong request received
						copyOfaddProduct = null;
					} else { // non-error (not wrong request)

						String matchedUriPattern_tRESTRequest_2 = (String) requestMessage_tRESTRequest_2.get("PATTERN");
						String matchedFlow_tRESTRequest_2 = (String) requestMessage_tRESTRequest_2.get("OPERATION");

						java.util.Map<String, Object> params_tRESTRequest_2 = (java.util.Map<String, Object>) requestMessage_tRESTRequest_2
								.get("PARAMS");
						if (matchedFlow_tRESTRequest_2.equals("copyOfaddProduct")) {
							copyOfaddProduct = new copyOfaddProductStruct();
							Object bodyObject_tRESTRequest_2 = requestMessage_tRESTRequest_2.get("BODY");
							if (null != bodyObject_tRESTRequest_2) {

								routines.system.Document body_tRESTRequest_2 = new routines.system.Document();
								body_tRESTRequest_2.setDocument((org.dom4j.Document) bodyObject_tRESTRequest_2);
								copyOfaddProduct.body = body_tRESTRequest_2;

							}
						} else { // non matched flow
							copyOfaddProduct = null;
						}

					}

					globalMap.put("tRESTRequest_2_URI", (String) requestMessage_tRESTRequest_2.get("URI"));
					globalMap.put("tRESTRequest_2_URI_BASE", (String) requestMessage_tRESTRequest_2.get("URI_BASE"));
					globalMap.put("tRESTRequest_2_URI_ABSOLUTE",
							(String) requestMessage_tRESTRequest_2.get("URI_ABSOLUTE"));
					globalMap.put("tRESTRequest_2_URI_REQUEST",
							(String) requestMessage_tRESTRequest_2.get("URI_REQUEST"));
					globalMap.put("tRESTRequest_2_HTTP_METHOD", (String) requestMessage_tRESTRequest_2.get("VERB"));

					globalMap.put("tRESTRequest_2_ATTACHMENT_HEADERS",
							requestMessage_tRESTRequest_2.get("ATTACHMENT_HEADERS"));
					globalMap.put("tRESTRequest_2_ATTACHMENT_FILENAMES",
							requestMessage_tRESTRequest_2.get("ATTACHMENT_FILENAMES"));

					globalMap.put("tRESTRequest_2_PRINCIPAL_NAME",
							(String) requestMessage_tRESTRequest_2.get("PRINCIPAL_NAME"));
					globalMap.put("tRESTRequest_2_CORRELATION_ID",
							(String) requestMessage_tRESTRequest_2.get("CorrelationID"));

					tos_count_tRESTRequest_2_In++;

					/**
					 * [tRESTRequest_2_In main ] stop
					 */

					/**
					 * [tRESTRequest_2_In process_data_begin ] start
					 */

					currentVirtualComponent = "tRESTRequest_2";

					currentComponent = "tRESTRequest_2_In";

					/**
					 * [tRESTRequest_2_In process_data_begin ] stop
					 */
// Start of branch "copyOfaddProduct"
					if (copyOfaddProduct != null) {

						/**
						 * [tXMLMap_3_TXMLMAP_OUT main ] start
						 */

						currentVirtualComponent = "tXMLMap_3";

						currentComponent = "tXMLMap_3_TXMLMAP_OUT";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "copyOfaddProduct"

							);
						}

						boolean rejectedInnerJoin_tXMLMap_3_TXMLMAP_OUT = false;
						boolean rejectedDocInnerJoin_tXMLMap_3_TXMLMAP_OUT = false;
						boolean mainRowRejected_tXMLMap_3_TXMLMAP_OUT = false;
						boolean isMatchDocRowtXMLMap_3_TXMLMAP_OUT = false;

						// init document to flat tool
						routines.system.DocumentToFlat docToFlat_tXMLMap_3_TXMLMAP_OUT = new routines.system.DocumentToFlat();
						docToFlat_tXMLMap_3_TXMLMAP_OUT.setOriginalLoop("/products/product");
						docToFlat_tXMLMap_3_TXMLMAP_OUT.setIsOptional(false);
						if (copyOfaddProduct.body == null || copyOfaddProduct.body.getDocument() == null) {
							throw new RuntimeException("copyOfaddProduct.body can't be empty");
						}
						org.dom4j.Document doc_tXMLMap_3_TXMLMAP_OUT = copyOfaddProduct.body.getDocument();
						docToFlat_tXMLMap_3_TXMLMAP_OUT.setDoc(doc_tXMLMap_3_TXMLMAP_OUT);
						docToFlat_tXMLMap_3_TXMLMAP_OUT.setDefineNS(false);
						docToFlat_tXMLMap_3_TXMLMAP_OUT.setNamespaceTool(nsTool_tXMLMap_3_TXMLMAP_OUT);

						// old version, find NS from doc
						nsTool_tXMLMap_3_TXMLMAP_OUT.countNSMap(doc_tXMLMap_3_TXMLMAP_OUT.getRootElement());
						java.util.HashMap<String, String> xmlNameSpaceMap_tXMLMap_3_TXMLMAP_OUT = nsTool_tXMLMap_3_TXMLMAP_OUT.xmlNameSpaceMap;

						docToFlat_tXMLMap_3_TXMLMAP_OUT.setXmlNameSpaceMap(xmlNameSpaceMap_tXMLMap_3_TXMLMAP_OUT);

						String[] absolutePathMappings_tXMLMap_3_TXMLMAP_OUT = new String[5];
						String[] relativePathMappings_tXMLMap_3_TXMLMAP_OUT = new String[5];

						absolutePathMappings_tXMLMap_3_TXMLMAP_OUT[0] = "copyOfaddProduct.body:/products/product/CD_PRODUIT";
						relativePathMappings_tXMLMap_3_TXMLMAP_OUT[0] = "CD_PRODUIT";

						absolutePathMappings_tXMLMap_3_TXMLMAP_OUT[1] = "copyOfaddProduct.body:/products/product/PRIX_VENTE_PRODUIT";
						relativePathMappings_tXMLMap_3_TXMLMAP_OUT[1] = "PRIX_VENTE_PRODUIT";

						absolutePathMappings_tXMLMap_3_TXMLMAP_OUT[2] = "copyOfaddProduct.body:/products/product/CD_SOUS_CATEGORIE";
						relativePathMappings_tXMLMap_3_TXMLMAP_OUT[2] = "CD_SOUS_CATEGORIE";

						absolutePathMappings_tXMLMap_3_TXMLMAP_OUT[3] = "copyOfaddProduct.body:/products/product/PRIX_ACHAT_PRODUIT";
						relativePathMappings_tXMLMap_3_TXMLMAP_OUT[3] = "PRIX_ACHAT_PRODUIT";

						absolutePathMappings_tXMLMap_3_TXMLMAP_OUT[4] = "copyOfaddProduct.body:/products/product/NOM_PRODUIT";
						relativePathMappings_tXMLMap_3_TXMLMAP_OUT[4] = "NOM_PRODUIT";

						docToFlat_tXMLMap_3_TXMLMAP_OUT
								.setAbsolutePathMappings(absolutePathMappings_tXMLMap_3_TXMLMAP_OUT);
						docToFlat_tXMLMap_3_TXMLMAP_OUT
								.setCurrentRelativePathMappings(relativePathMappings_tXMLMap_3_TXMLMAP_OUT);
						// generate document to flat data
						docToFlat_tXMLMap_3_TXMLMAP_OUT.flat();
						// get flat data
						java.util.List<java.util.Map<String, String>> resultSet_tXMLMap_3_TXMLMAP_OUT = docToFlat_tXMLMap_3_TXMLMAP_OUT
								.getResultSet();

						for (java.util.Map<String, String> oneRow_tXMLMap_3_TXMLMAP_OUT : resultSet_tXMLMap_3_TXMLMAP_OUT) { // G_TXM_M_001
							nb_line_tXMLMap_3_TXMLMAP_OUT++;
							rejectedInnerJoin_tXMLMap_3_TXMLMAP_OUT = false;
							rejectedDocInnerJoin_tXMLMap_3_TXMLMAP_OUT = false;
							mainRowRejected_tXMLMap_3_TXMLMAP_OUT = false;
							isMatchDocRowtXMLMap_3_TXMLMAP_OUT = false;

							treeNodeAPI_tXMLMap_3_TXMLMAP_OUT.clear();
							for (java.util.Map.Entry<String, String> entry_tXMLMap_3_TXMLMAP_OUT : oneRow_tXMLMap_3_TXMLMAP_OUT
									.entrySet()) {
								treeNodeAPI_tXMLMap_3_TXMLMAP_OUT.put(entry_tXMLMap_3_TXMLMAP_OUT.getKey(),
										entry_tXMLMap_3_TXMLMAP_OUT.getValue());
							}

							{ // start of Var scope

								// ###############################
								// # Vars tables

								Var__tXMLMap_3_TXMLMAP_OUT__Struct Var = Var__tXMLMap_3_TXMLMAP_OUT;
								// ###############################
								// # Output tables

								copyOfaddProducts = null;

// # Output table : 'copyOfaddProducts'

								copyOfaddProducts_tmp = new copyOfaddProductsStruct();
								copyOfaddProducts_tmp.CD_PRODUIT = treeNodeAPI_tXMLMap_3_TXMLMAP_OUT
										.get_String("copyOfaddProduct.body:/products/product/CD_PRODUIT");
								copyOfaddProducts_tmp.NOM_PRODUIT = treeNodeAPI_tXMLMap_3_TXMLMAP_OUT
										.get_String("copyOfaddProduct.body:/products/product/NOM_PRODUIT");
								copyOfaddProducts_tmp.PRIX_ACHAT_PRODUIT = treeNodeAPI_tXMLMap_3_TXMLMAP_OUT
										.get_Float("copyOfaddProduct.body:/products/product/PRIX_ACHAT_PRODUIT");
								copyOfaddProducts_tmp.PRIX_VENTE_PRODUIT = treeNodeAPI_tXMLMap_3_TXMLMAP_OUT
										.get_Float("copyOfaddProduct.body:/products/product/PRIX_VENTE_PRODUIT");
								copyOfaddProducts_tmp.CD_SOUS_CATEGORIE = treeNodeAPI_tXMLMap_3_TXMLMAP_OUT
										.get_String("copyOfaddProduct.body:/products/product/CD_SOUS_CATEGORIE");
								allOutsForAggregate_tXMLMap_3.add(copyOfaddProducts_tmp);

// ###############################

							} // end of Var scope

							rejectedInnerJoin_tXMLMap_3_TXMLMAP_OUT = false;

						} // G_TXM_M_001 close

						tos_count_tXMLMap_3_TXMLMAP_OUT++;

						/**
						 * [tXMLMap_3_TXMLMAP_OUT main ] stop
						 */

						/**
						 * [tXMLMap_3_TXMLMAP_OUT process_data_begin ] start
						 */

						currentVirtualComponent = "tXMLMap_3";

						currentComponent = "tXMLMap_3_TXMLMAP_OUT";

						/**
						 * [tXMLMap_3_TXMLMAP_OUT process_data_begin ] stop
						 */

						/**
						 * [tXMLMap_3_TXMLMAP_OUT process_data_end ] start
						 */

						currentVirtualComponent = "tXMLMap_3";

						currentComponent = "tXMLMap_3_TXMLMAP_OUT";

						/**
						 * [tXMLMap_3_TXMLMAP_OUT process_data_end ] stop
						 */

					} // End of branch "copyOfaddProduct"

					/**
					 * [tRESTRequest_2_In process_data_end ] start
					 */

					currentVirtualComponent = "tRESTRequest_2";

					currentComponent = "tRESTRequest_2_In";

					/**
					 * [tRESTRequest_2_In process_data_end ] stop
					 */

					/**
					 * [tRESTRequest_2_In end ] start
					 */

					currentVirtualComponent = "tRESTRequest_2";

					currentComponent = "tRESTRequest_2_In";

					resourceMap.put("inIterateVComp", true);

					ok_Hash.put("tRESTRequest_2_In", true);
					end_Hash.put("tRESTRequest_2_In", System.currentTimeMillis());

					/**
					 * [tRESTRequest_2_In end ] stop
					 */

					/**
					 * [tXMLMap_3_TXMLMAP_OUT end ] start
					 */

					currentVirtualComponent = "tXMLMap_3";

					currentComponent = "tXMLMap_3_TXMLMAP_OUT";

					if (execStat) {
						runStat.updateStat(resourceMap, iterateId, 2, 0, "copyOfaddProduct");
					}

					ok_Hash.put("tXMLMap_3_TXMLMAP_OUT", true);
					end_Hash.put("tXMLMap_3_TXMLMAP_OUT", System.currentTimeMillis());

					/**
					 * [tXMLMap_3_TXMLMAP_OUT end ] stop
					 */

					/**
					 * [tDBOutput_2 begin ] start
					 */

					ok_Hash.put("tDBOutput_2", false);
					start_Hash.put("tDBOutput_2", System.currentTimeMillis());

					currentComponent = "tDBOutput_2";

					if (execStat) {
						runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "copyOfaddProducts");
					}

					int tos_count_tDBOutput_2 = 0;

					int nb_line_tDBOutput_2 = 0;
					int nb_line_update_tDBOutput_2 = 0;
					int nb_line_inserted_tDBOutput_2 = 0;
					int nb_line_deleted_tDBOutput_2 = 0;
					int nb_line_rejected_tDBOutput_2 = 0;

					int deletedCount_tDBOutput_2 = 0;
					int updatedCount_tDBOutput_2 = 0;
					int insertedCount_tDBOutput_2 = 0;
					int rowsToCommitCount_tDBOutput_2 = 0;
					int rejectedCount_tDBOutput_2 = 0;

					String tableName_tDBOutput_2 = "tb_produit";
					boolean whetherReject_tDBOutput_2 = false;

					java.util.Calendar calendar_tDBOutput_2 = java.util.Calendar.getInstance();
					calendar_tDBOutput_2.set(1, 0, 1, 0, 0, 0);
					long year1_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
					calendar_tDBOutput_2.set(10000, 0, 1, 0, 0, 0);
					long year10000_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
					long date_tDBOutput_2;

					java.sql.Connection conn_tDBOutput_2 = null;

					String properties_tDBOutput_2 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
					if (properties_tDBOutput_2 == null || properties_tDBOutput_2.trim().length() == 0) {
						properties_tDBOutput_2 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
					} else {
						if (!properties_tDBOutput_2.contains("rewriteBatchedStatements=")) {
							properties_tDBOutput_2 += "&rewriteBatchedStatements=true";
						}

						if (!properties_tDBOutput_2.contains("allowLoadLocalInfile=")) {
							properties_tDBOutput_2 += "&allowLoadLocalInfile=true";
						}
					}

					String url_tDBOutput_2 = "jdbc:mariadb://" + "localhost" + ":" + "3304" + "/" + "icommerce" + "?"
							+ properties_tDBOutput_2;

					String driverClass_tDBOutput_2 = "org.mariadb.jdbc.Driver";

					String dbUser_tDBOutput_2 = "root";

					final String decryptedPassword_tDBOutput_2 = routines.system.PasswordEncryptUtil.decryptPassword(
							"enc:routine.encryption.key.v1:GiIcR/Wf6UxX5k0sIsvZkUVdNtHyg4TCqqbTj9OjjkE=");

					String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;
					java.lang.Class.forName(driverClass_tDBOutput_2);

					conn_tDBOutput_2 = java.sql.DriverManager.getConnection(url_tDBOutput_2, dbUser_tDBOutput_2,
							dbPwd_tDBOutput_2);

					resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);
					conn_tDBOutput_2.setAutoCommit(false);
					int commitEvery_tDBOutput_2 = 10000;
					int commitCounter_tDBOutput_2 = 0;

					int count_tDBOutput_2 = 0;

					String insert_tDBOutput_2 = "INSERT INTO `" + "tb_produit"
							+ "` (`CD_PRODUIT`,`NOM_PRODUIT`,`PRIX_ACHAT_PRODUIT`,`PRIX_VENTE_PRODUIT`,`CD_SOUS_CATEGORIE`) VALUES (?,?,?,?,?)";
					int batchSize_tDBOutput_2 = 100;
					int batchSizeCounter_tDBOutput_2 = 0;

					java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2
							.prepareStatement(insert_tDBOutput_2);
					resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);

					/**
					 * [tDBOutput_2 begin ] stop
					 */

					/**
					 * [tXMLMap_3_TXMLMAP_IN begin ] start
					 */

					ok_Hash.put("tXMLMap_3_TXMLMAP_IN", false);
					start_Hash.put("tXMLMap_3_TXMLMAP_IN", System.currentTimeMillis());

					currentVirtualComponent = "tXMLMap_3";

					currentComponent = "tXMLMap_3_TXMLMAP_IN";

					int tos_count_tXMLMap_3_TXMLMAP_IN = 0;

					java.util.List<Object> outs_tXMLMap_3 = (java.util.List<Object>) globalMap
							.get("allOutsForAggregate_tXMLMap_3");
					for (Object row_out_tXMLMap_3_TXMLMAP_IN : outs_tXMLMap_3) {// TD512

						/**
						 * [tXMLMap_3_TXMLMAP_IN begin ] stop
						 */

						/**
						 * [tXMLMap_3_TXMLMAP_IN main ] start
						 */

						currentVirtualComponent = "tXMLMap_3";

						currentComponent = "tXMLMap_3_TXMLMAP_IN";

						copyOfaddProducts = null;
						if (row_out_tXMLMap_3_TXMLMAP_IN != null
								&& row_out_tXMLMap_3_TXMLMAP_IN instanceof copyOfaddProductsStruct) {
							copyOfaddProducts = (copyOfaddProductsStruct) row_out_tXMLMap_3_TXMLMAP_IN;
						}

						tos_count_tXMLMap_3_TXMLMAP_IN++;

						/**
						 * [tXMLMap_3_TXMLMAP_IN main ] stop
						 */

						/**
						 * [tXMLMap_3_TXMLMAP_IN process_data_begin ] start
						 */

						currentVirtualComponent = "tXMLMap_3";

						currentComponent = "tXMLMap_3_TXMLMAP_IN";

						/**
						 * [tXMLMap_3_TXMLMAP_IN process_data_begin ] stop
						 */
// Start of branch "copyOfaddProducts"
						if (copyOfaddProducts != null) {

							/**
							 * [tDBOutput_2 main ] start
							 */

							currentComponent = "tDBOutput_2";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "copyOfaddProducts"

								);
							}

							whetherReject_tDBOutput_2 = false;
							if (copyOfaddProducts.CD_PRODUIT == null) {
								pstmt_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(1, copyOfaddProducts.CD_PRODUIT);
							}

							if (copyOfaddProducts.NOM_PRODUIT == null) {
								pstmt_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(2, copyOfaddProducts.NOM_PRODUIT);
							}

							if (copyOfaddProducts.PRIX_ACHAT_PRODUIT == null) {
								pstmt_tDBOutput_2.setNull(3, java.sql.Types.FLOAT);
							} else {
								pstmt_tDBOutput_2.setFloat(3, copyOfaddProducts.PRIX_ACHAT_PRODUIT);
							}

							if (copyOfaddProducts.PRIX_VENTE_PRODUIT == null) {
								pstmt_tDBOutput_2.setNull(4, java.sql.Types.FLOAT);
							} else {
								pstmt_tDBOutput_2.setFloat(4, copyOfaddProducts.PRIX_VENTE_PRODUIT);
							}

							if (copyOfaddProducts.CD_SOUS_CATEGORIE == null) {
								pstmt_tDBOutput_2.setNull(5, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_2.setString(5, copyOfaddProducts.CD_SOUS_CATEGORIE);
							}

							pstmt_tDBOutput_2.addBatch();
							nb_line_tDBOutput_2++;

							batchSizeCounter_tDBOutput_2++;
							if (!whetherReject_tDBOutput_2) {
							}
							if (batchSize_tDBOutput_2 <= batchSizeCounter_tDBOutput_2) {
								try {
									int countSum_tDBOutput_2 = 0;
									for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
										countSum_tDBOutput_2 += (countEach_tDBOutput_2 == java.sql.Statement.EXECUTE_FAILED
												? 0
												: 1);
									}
									rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
									insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
								} catch (java.sql.BatchUpdateException e) {
									globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());
									int countSum_tDBOutput_2 = 0;
									for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
										countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
									}
									rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
									insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
									System.err.println(e.getMessage());
								}

								batchSizeCounter_tDBOutput_2 = 0;
							}
							commitCounter_tDBOutput_2++;

							if (commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {

								try {
									int countSum_tDBOutput_2 = 0;
									for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
										countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : 1);
									}
									rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
									insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
								} catch (java.sql.BatchUpdateException e) {
									globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());
									int countSum_tDBOutput_2 = 0;
									for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
										countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
									}
									rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
									insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
									System.err.println(e.getMessage());

								}
								if (rowsToCommitCount_tDBOutput_2 != 0) {
								}
								conn_tDBOutput_2.commit();
								if (rowsToCommitCount_tDBOutput_2 != 0) {
									rowsToCommitCount_tDBOutput_2 = 0;
								}
								commitCounter_tDBOutput_2 = 0;

							}

							tos_count_tDBOutput_2++;

							/**
							 * [tDBOutput_2 main ] stop
							 */

							/**
							 * [tDBOutput_2 process_data_begin ] start
							 */

							currentComponent = "tDBOutput_2";

							/**
							 * [tDBOutput_2 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_2 process_data_end ] start
							 */

							currentComponent = "tDBOutput_2";

							/**
							 * [tDBOutput_2 process_data_end ] stop
							 */

						} // End of branch "copyOfaddProducts"

						/**
						 * [tXMLMap_3_TXMLMAP_IN process_data_end ] start
						 */

						currentVirtualComponent = "tXMLMap_3";

						currentComponent = "tXMLMap_3_TXMLMAP_IN";

						/**
						 * [tXMLMap_3_TXMLMAP_IN process_data_end ] stop
						 */

						/**
						 * [tXMLMap_3_TXMLMAP_IN end ] start
						 */

						currentVirtualComponent = "tXMLMap_3";

						currentComponent = "tXMLMap_3_TXMLMAP_IN";

					} // TD512

					ok_Hash.put("tXMLMap_3_TXMLMAP_IN", true);
					end_Hash.put("tXMLMap_3_TXMLMAP_IN", System.currentTimeMillis());

					/**
					 * [tXMLMap_3_TXMLMAP_IN end ] stop
					 */

					/**
					 * [tDBOutput_2 end ] start
					 */

					currentComponent = "tDBOutput_2";

					try {
						if (batchSizeCounter_tDBOutput_2 != 0) {
							int countSum_tDBOutput_2 = 0;

							for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
								countSum_tDBOutput_2 += (countEach_tDBOutput_2 == java.sql.Statement.EXECUTE_FAILED ? 0
										: 1);
							}
							rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

							insertedCount_tDBOutput_2 += countSum_tDBOutput_2;

						}

					} catch (java.sql.BatchUpdateException e) {
						globalMap.put(currentComponent + "_ERROR_MESSAGE", e.getMessage());

						int countSum_tDBOutput_2 = 0;
						for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
							countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
						}
						rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

						insertedCount_tDBOutput_2 += countSum_tDBOutput_2;

						System.err.println(e.getMessage());

					}
					batchSizeCounter_tDBOutput_2 = 0;

					if (pstmt_tDBOutput_2 != null) {

						pstmt_tDBOutput_2.close();
						resourceMap.remove("pstmt_tDBOutput_2");

					}
					resourceMap.put("statementClosed_tDBOutput_2", true);
					if (commitCounter_tDBOutput_2 > 0 && rowsToCommitCount_tDBOutput_2 != 0) {

					}
					conn_tDBOutput_2.commit();
					if (commitCounter_tDBOutput_2 > 0 && rowsToCommitCount_tDBOutput_2 != 0) {

						rowsToCommitCount_tDBOutput_2 = 0;
					}
					commitCounter_tDBOutput_2 = 0;

					conn_tDBOutput_2.close();

					resourceMap.put("finish_tDBOutput_2", true);

					nb_line_deleted_tDBOutput_2 = nb_line_deleted_tDBOutput_2 + deletedCount_tDBOutput_2;
					nb_line_update_tDBOutput_2 = nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
					nb_line_inserted_tDBOutput_2 = nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
					nb_line_rejected_tDBOutput_2 = nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;

					globalMap.put("tDBOutput_2_NB_LINE", nb_line_tDBOutput_2);
					globalMap.put("tDBOutput_2_NB_LINE_UPDATED", nb_line_update_tDBOutput_2);
					globalMap.put("tDBOutput_2_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_2);
					globalMap.put("tDBOutput_2_NB_LINE_DELETED", nb_line_deleted_tDBOutput_2);
					globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);

					if (execStat) {
						runStat.updateStat(resourceMap, iterateId, 2, 0, "copyOfaddProducts");
					}

					ok_Hash.put("tDBOutput_2", true);
					end_Hash.put("tDBOutput_2", System.currentTimeMillis());

					if (execStat) {
						runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
					}
					tFixedFlowInput_2Process(globalMap);

					/**
					 * [tDBOutput_2 end ] stop
					 */

					if (execStat) {
						runStat.updateStatOnConnection("Iterate", 2, "exec" + NB_ITERATE_tRESTRequest_2_In);
					}

					/**
					 * [tRESTRequest_2_Loop process_data_end ] start
					 */

					currentVirtualComponent = "tRESTRequest_2";

					currentComponent = "tRESTRequest_2_Loop";

					/**
					 * [tRESTRequest_2_Loop process_data_end ] stop
					 */

					/**
					 * [tRESTRequest_2_Loop end ] start
					 */

					currentVirtualComponent = "tRESTRequest_2";

					currentComponent = "tRESTRequest_2_Loop";

					resourceMap.remove("inIterateVComp");

				} catch (Throwable e_tRESTRequest_2) {
					if (e_tRESTRequest_2 instanceof Exception) {
						new TalendException((Exception) e_tRESTRequest_2, currentComponent, globalMap)
								.printStackTrace();
					} else {
						new TalendException(new RuntimeException(e_tRESTRequest_2), currentComponent, globalMap)
								.printStackTrace();
					}
					if (!globalMap.containsKey("restResponse")) {
						java.util.Map<String, Object> restFault_tRESTRequest_2 = new java.util.HashMap<String, Object>();
						restFault_tRESTRequest_2.put("STATUS", 500);
						restFault_tRESTRequest_2.put("BODY", e_tRESTRequest_2.getMessage());
						globalMap.put("restResponse", restFault_tRESTRequest_2);
					}
					return;
				}
				nb_line_tRESTRequest_2++;
				globalMap.put("tRESTRequest_2_NB_LINE", nb_line_tRESTRequest_2);

				if (execStat) {
					runStat.updateStatOnConnection(iterateId, 2, 0, "copyOfaddProduct", "copyOfaddProducts");
				}

				ok_Hash.put("tRESTRequest_2_Loop", true);
				end_Hash.put("tRESTRequest_2_Loop", System.currentTimeMillis());

				/**
				 * [tRESTRequest_2_Loop end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			te.setVirtualComponentName(currentVirtualComponent);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tRESTRequest_2_Loop finally ] start
				 */

				currentVirtualComponent = "tRESTRequest_2";

				currentComponent = "tRESTRequest_2_Loop";

				/**
				 * [tRESTRequest_2_Loop finally ] stop
				 */

				/**
				 * [tRESTRequest_2_In finally ] start
				 */

				currentVirtualComponent = "tRESTRequest_2";

				currentComponent = "tRESTRequest_2_In";

				/**
				 * [tRESTRequest_2_In finally ] stop
				 */

				/**
				 * [tXMLMap_3_TXMLMAP_OUT finally ] start
				 */

				currentVirtualComponent = "tXMLMap_3";

				currentComponent = "tXMLMap_3_TXMLMAP_OUT";

				/**
				 * [tXMLMap_3_TXMLMAP_OUT finally ] stop
				 */

				/**
				 * [tXMLMap_3_TXMLMAP_IN finally ] start
				 */

				currentVirtualComponent = "tXMLMap_3";

				currentComponent = "tXMLMap_3_TXMLMAP_IN";

				/**
				 * [tXMLMap_3_TXMLMAP_IN finally ] stop
				 */

				/**
				 * [tDBOutput_2 finally ] start
				 */

				currentComponent = "tDBOutput_2";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
						if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_2")) != null) {
							pstmtToClose_tDBOutput_2.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_2") == null) {
						java.sql.Connection ctn_tDBOutput_2 = null;
						if ((ctn_tDBOutput_2 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_2")) != null) {
							try {
								ctn_tDBOutput_2.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_2) {
								String errorMessage_tDBOutput_2 = "failed to close the connection in tDBOutput_2 :"
										+ sqlEx_tDBOutput_2.getMessage();
								System.err.println(errorMessage_tDBOutput_2);
							}
						}
					}
				}

				/**
				 * [tDBOutput_2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRESTRequest_2_Loop_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final jRestRequestAddProduct jRestRequestAddProductClass = new jRestRequestAddProduct();

		int exitCode = jRestRequestAddProductClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (inOSGi) {
			java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

			if (jobProperties != null && jobProperties.get("context") != null) {
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = jRestRequestAddProduct.class.getClassLoader().getResourceAsStream(
					"projet_esb_adda/jrestrequestaddproduct_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = jRestRequestAddProduct.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tRESTRequest_2_LoopProcess(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tRESTRequest_2_Loop) {
			globalMap.put("tRESTRequest_2_Loop_SUBPROCESS_STATE", -1);

			e_tRESTRequest_2_Loop.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : jRestRequestAddProduct");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 118982 characters generated by Talend Open Studio for ESB on the 7 mars 2024
 * à 01:01:51 CET
 ************************************************************************************************/