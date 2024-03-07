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

package projet_esb_adda.jrestclientpost_0_1;

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
 * Job: jRestClientPost Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class jRestClientPost implements TalendJob {

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
	private final String jobName = "jRestClientPost";
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
					jRestClientPost.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(jRestClientPost.this, new Object[] { e, currentComponent, globalMap });
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

	public void tFileInputXML_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputXML_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTClient_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputXML_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputXML_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputXML_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class ContextBean {
		static String evaluate(String context, String contextExpression)
				throws IOException, javax.script.ScriptException {
			boolean isExpression = contextExpression.contains("+") || contextExpression.contains("(");
			final String prefix = isExpression ? "\"" : "";
			java.util.Properties defaultProps = new java.util.Properties();
			java.io.InputStream inContext = jRestClientPost.class.getClassLoader()
					.getResourceAsStream("projet_esb_adda/jrestclientpost_0_1/contexts/" + context + ".properties");
			if (inContext == null) {
				inContext = jRestClientPost.class.getClassLoader()
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

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_PROJET_ESB_ADDA_jRestClientPost = new byte[0];
		static byte[] commonByteArray_PROJET_ESB_ADDA_jRestClientPost = new byte[0];

		public Integer statusCode;

		public Integer getStatusCode() {
			return this.statusCode;
		}

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		public String string;

		public String getString() {
			return this.string;
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJET_ESB_ADDA_jRestClientPost.length) {
					if (length < 1024 && commonByteArray_PROJET_ESB_ADDA_jRestClientPost.length == 0) {
						commonByteArray_PROJET_ESB_ADDA_jRestClientPost = new byte[1024];
					} else {
						commonByteArray_PROJET_ESB_ADDA_jRestClientPost = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJET_ESB_ADDA_jRestClientPost, 0, length);
				strReturn = new String(commonByteArray_PROJET_ESB_ADDA_jRestClientPost, 0, length, utf8Charset);
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
				if (length > commonByteArray_PROJET_ESB_ADDA_jRestClientPost.length) {
					if (length < 1024 && commonByteArray_PROJET_ESB_ADDA_jRestClientPost.length == 0) {
						commonByteArray_PROJET_ESB_ADDA_jRestClientPost = new byte[1024];
					} else {
						commonByteArray_PROJET_ESB_ADDA_jRestClientPost = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PROJET_ESB_ADDA_jRestClientPost, 0, length);
				strReturn = new String(commonByteArray_PROJET_ESB_ADDA_jRestClientPost, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_PROJET_ESB_ADDA_jRestClientPost) {

				try {

					int length = 0;

					this.statusCode = readInteger(dis);

					this.body = (routines.system.Document) dis.readObject();

					this.string = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJET_ESB_ADDA_jRestClientPost) {

				try {

					int length = 0;

					this.statusCode = readInteger(dis);

					this.body = (routines.system.Document) dis.readObject();

					this.string = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.statusCode, dos);

				// Document

				dos.writeObject(this.body);

				// String

				writeString(this.string, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.statusCode, dos);

				// Document

				dos.writeObject(this.body);

				// String

				writeString(this.string, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("statusCode=" + String.valueOf(statusCode));
			sb.append(",body=" + String.valueOf(body));
			sb.append(",string=" + string);
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

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_PROJET_ESB_ADDA_jRestClientPost = new byte[0];
		static byte[] commonByteArray_PROJET_ESB_ADDA_jRestClientPost = new byte[0];

		public String body;

		public String getBody() {
			return this.body;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJET_ESB_ADDA_jRestClientPost.length) {
					if (length < 1024 && commonByteArray_PROJET_ESB_ADDA_jRestClientPost.length == 0) {
						commonByteArray_PROJET_ESB_ADDA_jRestClientPost = new byte[1024];
					} else {
						commonByteArray_PROJET_ESB_ADDA_jRestClientPost = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJET_ESB_ADDA_jRestClientPost, 0, length);
				strReturn = new String(commonByteArray_PROJET_ESB_ADDA_jRestClientPost, 0, length, utf8Charset);
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
				if (length > commonByteArray_PROJET_ESB_ADDA_jRestClientPost.length) {
					if (length < 1024 && commonByteArray_PROJET_ESB_ADDA_jRestClientPost.length == 0) {
						commonByteArray_PROJET_ESB_ADDA_jRestClientPost = new byte[1024];
					} else {
						commonByteArray_PROJET_ESB_ADDA_jRestClientPost = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PROJET_ESB_ADDA_jRestClientPost, 0, length);
				strReturn = new String(commonByteArray_PROJET_ESB_ADDA_jRestClientPost, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_PROJET_ESB_ADDA_jRestClientPost) {

				try {

					int length = 0;

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJET_ESB_ADDA_jRestClientPost) {

				try {

					int length = 0;

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.body, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.body, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("body=" + body);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

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

	public void tFileInputXML_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputXML_1_SUBPROCESS_STATE", 0);

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

				row1Struct row1 = new row1Struct();
				row2Struct row2 = new row2Struct();

				/**
				 * [tLogRow_1 begin ] start
				 */

				ok_Hash.put("tLogRow_1", false);
				start_Hash.put("tLogRow_1", System.currentTimeMillis());

				currentComponent = "tLogRow_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
				}

				int tos_count_tLogRow_1 = 0;

				///////////////////////

				final String OUTPUT_FIELD_SEPARATOR_tLogRow_1 = "|";
				java.io.PrintStream consoleOut_tLogRow_1 = null;

				StringBuilder strBuffer_tLogRow_1 = null;
				int nb_line_tLogRow_1 = 0;
///////////////////////    			

				/**
				 * [tLogRow_1 begin ] stop
				 */

				/**
				 * [tRESTClient_1 begin ] start
				 */

				ok_Hash.put("tRESTClient_1", false);
				start_Hash.put("tRESTClient_1", System.currentTimeMillis());

				currentComponent = "tRESTClient_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tRESTClient_1 = 0;

				/**
				 * [tRESTClient_1 begin ] stop
				 */

				/**
				 * [tFileInputXML_1 begin ] start
				 */

				ok_Hash.put("tFileInputXML_1", false);
				start_Hash.put("tFileInputXML_1", System.currentTimeMillis());

				currentComponent = "tFileInputXML_1";

				int tos_count_tFileInputXML_1 = 0;

				int nb_line_tFileInputXML_1 = 0;

				String os_tFileInputXML_1 = System.getProperty("os.name").toLowerCase();
				boolean isWindows_tFileInputXML_1 = false;
				if (os_tFileInputXML_1.indexOf("windows") > -1 || os_tFileInputXML_1.indexOf("nt") > -1) {
					isWindows_tFileInputXML_1 = true;
				}
				class NameSpaceTool_tFileInputXML_1 {

					public java.util.HashMap<String, String> xmlNameSpaceMap = new java.util.HashMap<String, String>();

					private java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();

					public void countNSMap(org.dom4j.Element el) {
						for (org.dom4j.Namespace ns : (java.util.List<org.dom4j.Namespace>) el.declaredNamespaces()) {
							if (ns.getPrefix().trim().length() == 0) {
								xmlNameSpaceMap.put("pre" + defualtNSPath.size(), ns.getURI());
								String path = "";
								org.dom4j.Element elTmp = el;
								while (elTmp != null) {
									if (elTmp.getNamespacePrefix() != null && elTmp.getNamespacePrefix().length() > 0) {
										path = "/" + elTmp.getNamespacePrefix() + ":" + elTmp.getName() + path;
									} else {
										path = "/" + elTmp.getName() + path;
									}
									elTmp = elTmp.getParent();
								}
								defualtNSPath.add(path);
							} else {
								xmlNameSpaceMap.put(ns.getPrefix(), ns.getURI());
							}

						}
						for (org.dom4j.Element e : (java.util.List<org.dom4j.Element>) el.elements()) {
							countNSMap(e);
						}
					}

					private final org.talend.xpath.XPathUtil util = new org.talend.xpath.XPathUtil();

					{
						util.setDefaultNSPath(defualtNSPath);
					}

					public String addDefaultNSPrefix(String path) {
						return util.addDefaultNSPrefix(path);
					}

					public String addDefaultNSPrefix(String relativeXpression, String basePath) {
						return util.addDefaultNSPrefix(relativeXpression, basePath);
					}

				}

				class XML_API_tFileInputXML_1 {
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

				org.dom4j.io.SAXReader reader_tFileInputXML_1 = new org.dom4j.io.SAXReader();
				Object filename_tFileInputXML_1 = null;
				try {
					filename_tFileInputXML_1 = "C:/TOS_ESB-20211109_1610-V8.0.1/Studio/workspace/PROJET_ESB_ADDA/TB_PRODUIT.xml";
				} catch (java.lang.Exception e) {
					globalMap.put("tFileInputXML_1_ERROR_MESSAGE", e.getMessage());

					System.err.println(e.getMessage());

				}
				if (filename_tFileInputXML_1 != null && filename_tFileInputXML_1 instanceof String
						&& filename_tFileInputXML_1.toString().startsWith("//")) {
					if (!isWindows_tFileInputXML_1) {
						filename_tFileInputXML_1 = filename_tFileInputXML_1.toString().replaceFirst("//", "/");
					}
				}

				boolean isValidFile_tFileInputXML_1 = true;
				org.dom4j.Document doc_tFileInputXML_1 = null;
				java.io.Closeable toClose_tFileInputXML_1 = null;
				try {
					if (filename_tFileInputXML_1 instanceof java.io.InputStream) {
						java.io.InputStream inputStream_tFileInputXML_1 = (java.io.InputStream) filename_tFileInputXML_1;
						toClose_tFileInputXML_1 = inputStream_tFileInputXML_1;
						doc_tFileInputXML_1 = reader_tFileInputXML_1.read(inputStream_tFileInputXML_1);
					} else {
						java.io.Reader unicodeReader_tFileInputXML_1 = new UnicodeReader(
								new java.io.FileInputStream(String.valueOf(filename_tFileInputXML_1)), "ISO-8859-15");
						toClose_tFileInputXML_1 = unicodeReader_tFileInputXML_1;
						org.xml.sax.InputSource in_tFileInputXML_1 = new org.xml.sax.InputSource(
								unicodeReader_tFileInputXML_1);
						doc_tFileInputXML_1 = reader_tFileInputXML_1.read(in_tFileInputXML_1);
					}
				} catch (java.lang.Exception e) {
					globalMap.put("tFileInputXML_1_ERROR_MESSAGE", e.getMessage());

					System.err.println(e.getMessage());
					isValidFile_tFileInputXML_1 = false;
				} finally {
					if (toClose_tFileInputXML_1 != null) {
						toClose_tFileInputXML_1.close();
					}
				}
				if (isValidFile_tFileInputXML_1) {
					NameSpaceTool_tFileInputXML_1 nsTool_tFileInputXML_1 = new NameSpaceTool_tFileInputXML_1();
					nsTool_tFileInputXML_1.countNSMap(doc_tFileInputXML_1.getRootElement());
					java.util.HashMap<String, String> xmlNameSpaceMap_tFileInputXML_1 = nsTool_tFileInputXML_1.xmlNameSpaceMap;

					org.dom4j.XPath x_tFileInputXML_1 = doc_tFileInputXML_1
							.createXPath(nsTool_tFileInputXML_1.addDefaultNSPrefix("/products"));
					x_tFileInputXML_1.setNamespaceURIs(xmlNameSpaceMap_tFileInputXML_1);

					java.util.List<org.dom4j.Node> nodeList_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) x_tFileInputXML_1
							.selectNodes(doc_tFileInputXML_1);
					XML_API_tFileInputXML_1 xml_api_tFileInputXML_1 = new XML_API_tFileInputXML_1();
					String str_tFileInputXML_1 = "";
					org.dom4j.Node node_tFileInputXML_1 = null;

//init all mapping xpaths
					java.util.Map<Integer, org.dom4j.XPath> xpaths_tFileInputXML_1 = new java.util.HashMap<Integer, org.dom4j.XPath>();
					class XPathUtil_tFileInputXML_1 {

						public void initXPaths_0(java.util.Map<Integer, org.dom4j.XPath> xpaths,
								NameSpaceTool_tFileInputXML_1 nsTool,
								java.util.HashMap<String, String> xmlNameSpaceMap) {

							org.dom4j.XPath xpath_0 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix(".", "/products"));
							xpath_0.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(0, xpath_0);

						}

						public void initXPaths(java.util.Map<Integer, org.dom4j.XPath> xpaths,
								NameSpaceTool_tFileInputXML_1 nsTool,
								java.util.HashMap<String, String> xmlNameSpaceMap) {

							initXPaths_0(xpaths, nsTool, xmlNameSpaceMap);

						}
					}
					XPathUtil_tFileInputXML_1 xPathUtil_tFileInputXML_1 = new XPathUtil_tFileInputXML_1();
					xPathUtil_tFileInputXML_1.initXPaths(xpaths_tFileInputXML_1, nsTool_tFileInputXML_1,
							xmlNameSpaceMap_tFileInputXML_1);
					for (org.dom4j.Node temp_tFileInputXML_1 : nodeList_tFileInputXML_1) {
						nb_line_tFileInputXML_1++;

						row1 = null;
						boolean whetherReject_tFileInputXML_1 = false;
						row1 = new row1Struct();
						try {
							Object obj0_tFileInputXML_1 = xpaths_tFileInputXML_1.get(0).evaluate(temp_tFileInputXML_1);
							if (obj0_tFileInputXML_1 == null) {
								node_tFileInputXML_1 = null;
								str_tFileInputXML_1 = null;

							} else if (obj0_tFileInputXML_1 instanceof org.dom4j.Node) {
								node_tFileInputXML_1 = (org.dom4j.Node) obj0_tFileInputXML_1;
								str_tFileInputXML_1 = node_tFileInputXML_1.asXML();
							} else if (obj0_tFileInputXML_1 instanceof String
									|| obj0_tFileInputXML_1 instanceof Number) {
								node_tFileInputXML_1 = temp_tFileInputXML_1;
								str_tFileInputXML_1 = String.valueOf(obj0_tFileInputXML_1);
							} else if (obj0_tFileInputXML_1 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) obj0_tFileInputXML_1;
								node_tFileInputXML_1 = nodes_tFileInputXML_1.size() > 0 ? nodes_tFileInputXML_1.get(0)
										: null;
								str_tFileInputXML_1 = node_tFileInputXML_1 == null ? null
										: node_tFileInputXML_1.asXML();
							}
							row1.body = str_tFileInputXML_1;

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputXML_1_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputXML_1 = true;
							System.err.println(e.getMessage());
							row1 = null;
						}

						/**
						 * [tFileInputXML_1 begin ] stop
						 */

						/**
						 * [tFileInputXML_1 main ] start
						 */

						currentComponent = "tFileInputXML_1";

						tos_count_tFileInputXML_1++;

						/**
						 * [tFileInputXML_1 main ] stop
						 */

						/**
						 * [tFileInputXML_1 process_data_begin ] start
						 */

						currentComponent = "tFileInputXML_1";

						/**
						 * [tFileInputXML_1 process_data_begin ] stop
						 */
// Start of branch "row1"
						if (row1 != null) {

							/**
							 * [tRESTClient_1 main ] start
							 */

							currentComponent = "tRESTClient_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row1"

								);
							}

							row2 = null;

// expected response body
							javax.ws.rs.core.Response responseDoc_tRESTClient_1 = null;

							try {
								// request body
								org.dom4j.Document requestDoc_tRESTClient_1 = null;
								String requestString_tRESTClient_1 = null;

								Object requestBody_tRESTClient_1 = requestDoc_tRESTClient_1 != null
										? requestDoc_tRESTClient_1
										: requestString_tRESTClient_1;

								// resposne class name
								Class<?> responseClass_tRESTClient_1 = org.dom4j.Document.class;

								// create web client instance
								org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean factoryBean_tRESTClient_1 = new org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean();

								boolean inOSGi = routines.system.BundleUtils.inOSGi();

								final java.util.List<org.apache.cxf.feature.Feature> features_tRESTClient_1 = new java.util.ArrayList<org.apache.cxf.feature.Feature>();

								String url = "http://localhost:8081/products/product";
								// {baseUri}tRESTClient
								factoryBean_tRESTClient_1
										.setServiceName(new javax.xml.namespace.QName(url, "tRESTClient"));
								factoryBean_tRESTClient_1.setAddress(url);

								factoryBean_tRESTClient_1.setFeatures(features_tRESTClient_1);

								java.util.List<Object> providers_tRESTClient_1 = new java.util.ArrayList<Object>();
								providers_tRESTClient_1.add(new org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider() {
									// workaround for https://jira.talendforge.org/browse/TESB-7276
									public org.dom4j.Document readFrom(Class<org.dom4j.Document> cls,
											java.lang.reflect.Type type, java.lang.annotation.Annotation[] anns,
											javax.ws.rs.core.MediaType mt,
											javax.ws.rs.core.MultivaluedMap<String, String> headers,
											java.io.InputStream is)
											throws IOException, javax.ws.rs.WebApplicationException {
										String contentLength = headers.getFirst("Content-Length");
										if (!org.apache.cxf.common.util.StringUtils.isEmpty(contentLength)
												&& Integer.valueOf(contentLength) <= 0) {
											try {
												return org.dom4j.DocumentHelper.parseText("<root/>");
											} catch (org.dom4j.DocumentException e_tRESTClient_1) {
												e_tRESTClient_1.printStackTrace();
											}
											return null;
										}
										return super.readFrom(cls, type, anns, mt, headers, is);
									}
								});
								org.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider_tRESTClient_1 = new org.apache.cxf.jaxrs.provider.json.JSONProvider();
								jsonProvider_tRESTClient_1.setIgnoreNamespaces(true);
								jsonProvider_tRESTClient_1.setAttributesToElements(true);

								jsonProvider_tRESTClient_1.setSupportUnwrapped(true);
								jsonProvider_tRESTClient_1.setWrapperName("root");

								jsonProvider_tRESTClient_1.setDropRootElement(false);
								jsonProvider_tRESTClient_1.setConvertTypesToStrings(false);
								providers_tRESTClient_1.add(jsonProvider_tRESTClient_1);
								factoryBean_tRESTClient_1.setProviders(providers_tRESTClient_1);
								factoryBean_tRESTClient_1.setTransportId("http://cxf.apache.org/transports/http");

								boolean use_auth_tRESTClient_1 = false;

								org.apache.cxf.jaxrs.client.WebClient webClient_tRESTClient_1 = factoryBean_tRESTClient_1
										.createWebClient();

								// set request path
								webClient_tRESTClient_1.path("");

								// set connection properties
								org.apache.cxf.jaxrs.client.ClientConfiguration clientConfig_tRESTClient_1 = org.apache.cxf.jaxrs.client.WebClient
										.getConfig(webClient_tRESTClient_1);
								org.apache.cxf.transport.http.auth.HttpAuthSupplier httpAuthSupplerHttpConduit = null;
								org.apache.cxf.transport.http.HTTPConduit conduit_tRESTClient_1 = clientConfig_tRESTClient_1
										.getHttpConduit();

								if (clientConfig_tRESTClient_1.getEndpoint() != null) {
									org.apache.cxf.service.model.EndpointInfo endpointInfo_tRESTClient_1 = clientConfig_tRESTClient_1
											.getEndpoint().getEndpointInfo();
									if (endpointInfo_tRESTClient_1 != null) {
										endpointInfo_tRESTClient_1.setProperty("enable.webclient.operation.reporting",
												true);
									}
								}

								if (!inOSGi) {
									conduit_tRESTClient_1.getClient().setReceiveTimeout((long) (60 * 1000L));
									conduit_tRESTClient_1.getClient().setConnectionTimeout((long) (30 * 1000L));
									boolean use_proxy_tRESTClient_1 = false;

								}

								// set Content-Type
								webClient_tRESTClient_1.type("application/xml");

								// set Accept-Type
								webClient_tRESTClient_1.accept("application/xml");

								// set optional query and header properties if any

								if (use_auth_tRESTClient_1 && "OAUTH2_BEARER".equals("BASIC")) {
									// set oAuth2 bearer token
									org.apache.cxf.rs.security.oauth2.client.BearerAuthSupplier authSupplier = new org.apache.cxf.rs.security.oauth2.client.BearerAuthSupplier();
									authSupplier.setAccessToken("");
									conduit_tRESTClient_1.setAuthSupplier(authSupplier);
								}

								// if FORM request then capture query parameters into Form, otherwise set them
								// as queries

								try {
									// start send request

									responseDoc_tRESTClient_1 = webClient_tRESTClient_1.post(requestBody_tRESTClient_1);

									int webClientResponseStatus_tRESTClient_1 = webClient_tRESTClient_1.getResponse()
											.getStatus();
									if (webClientResponseStatus_tRESTClient_1 >= 300) {
										throw new javax.ws.rs.WebApplicationException(
												webClient_tRESTClient_1.getResponse());
									}

									if (row2 == null) {
										row2 = new row2Struct();
									}

									row2.statusCode = webClientResponseStatus_tRESTClient_1;
									row2.string = "";

									Object responseObj_tRESTClient_1 = null;
									if (responseDoc_tRESTClient_1 != null && responseDoc_tRESTClient_1.hasEntity()) {
										responseObj_tRESTClient_1 = responseDoc_tRESTClient_1
												.readEntity(responseClass_tRESTClient_1);

										if (responseObj_tRESTClient_1 != null) {
											if (responseClass_tRESTClient_1 == String.class
													&& responseObj_tRESTClient_1 instanceof String) {
												row2.string = (String) responseObj_tRESTClient_1;
											} else {
												routines.system.Document responseTalendDoc_tRESTClient_1 = null;
												if (null != responseObj_tRESTClient_1) {
													responseTalendDoc_tRESTClient_1 = new routines.system.Document();
													if (responseObj_tRESTClient_1 instanceof org.dom4j.Document) {
														responseTalendDoc_tRESTClient_1.setDocument(
																(org.dom4j.Document) responseObj_tRESTClient_1);
													}
												}
												row2.body = responseTalendDoc_tRESTClient_1;
											}
										}
									}

									globalMap.put("tRESTClient_1_HEADERS",
											webClient_tRESTClient_1.getResponse().getHeaders());
									globalMap.put("tRESTClient_1_COOKIES",
											webClient_tRESTClient_1.getResponse().getCookies());

								} catch (javax.ws.rs.WebApplicationException ex_tRESTClient_1) {
									globalMap.put("tRESTClient_1_ERROR_MESSAGE", ex_tRESTClient_1.getMessage());

									throw ex_tRESTClient_1;

								}

							} catch (Exception e_tRESTClient_1) {
								globalMap.put("tRESTClient_1_ERROR_MESSAGE", e_tRESTClient_1.getMessage());

								throw new TalendException(e_tRESTClient_1, currentComponent, globalMap);

							}

							tos_count_tRESTClient_1++;

							/**
							 * [tRESTClient_1 main ] stop
							 */

							/**
							 * [tRESTClient_1 process_data_begin ] start
							 */

							currentComponent = "tRESTClient_1";

							/**
							 * [tRESTClient_1 process_data_begin ] stop
							 */
// Start of branch "row2"
							if (row2 != null) {

								/**
								 * [tLogRow_1 main ] start
								 */

								currentComponent = "tLogRow_1";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "row2"

									);
								}

///////////////////////		

								strBuffer_tLogRow_1 = new StringBuilder();

								if (row2.statusCode != null) { //

									strBuffer_tLogRow_1.append(String.valueOf(row2.statusCode));

								} //

								strBuffer_tLogRow_1.append("|");

								if (row2.body != null) { //

									strBuffer_tLogRow_1.append(String.valueOf(row2.body));

								} //

								strBuffer_tLogRow_1.append("|");

								if (row2.string != null) { //

									strBuffer_tLogRow_1.append(String.valueOf(row2.string));

								} //

								if (globalMap.get("tLogRow_CONSOLE") != null) {
									consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
								} else {
									consoleOut_tLogRow_1 = new java.io.PrintStream(
											new java.io.BufferedOutputStream(System.out));
									globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_1);
								}
								consoleOut_tLogRow_1.println(strBuffer_tLogRow_1.toString());
								consoleOut_tLogRow_1.flush();
								nb_line_tLogRow_1++;
//////

//////                    

///////////////////////    			

								tos_count_tLogRow_1++;

								/**
								 * [tLogRow_1 main ] stop
								 */

								/**
								 * [tLogRow_1 process_data_begin ] start
								 */

								currentComponent = "tLogRow_1";

								/**
								 * [tLogRow_1 process_data_begin ] stop
								 */

								/**
								 * [tLogRow_1 process_data_end ] start
								 */

								currentComponent = "tLogRow_1";

								/**
								 * [tLogRow_1 process_data_end ] stop
								 */

							} // End of branch "row2"

							/**
							 * [tRESTClient_1 process_data_end ] start
							 */

							currentComponent = "tRESTClient_1";

							/**
							 * [tRESTClient_1 process_data_end ] stop
							 */

						} // End of branch "row1"

						/**
						 * [tFileInputXML_1 process_data_end ] start
						 */

						currentComponent = "tFileInputXML_1";

						/**
						 * [tFileInputXML_1 process_data_end ] stop
						 */

						/**
						 * [tFileInputXML_1 end ] start
						 */

						currentComponent = "tFileInputXML_1";

					}
				}
				globalMap.put("tFileInputXML_1_NB_LINE", nb_line_tFileInputXML_1);

				ok_Hash.put("tFileInputXML_1", true);
				end_Hash.put("tFileInputXML_1", System.currentTimeMillis());

				/**
				 * [tFileInputXML_1 end ] stop
				 */

				/**
				 * [tRESTClient_1 end ] start
				 */

				currentComponent = "tRESTClient_1";

				if (globalMap.get("tRESTClient_1_NB_LINE") == null) {
					globalMap.put("tRESTClient_1_NB_LINE", 1);
				}

// [tRESTCliend_end]
				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				ok_Hash.put("tRESTClient_1", true);
				end_Hash.put("tRESTClient_1", System.currentTimeMillis());

				/**
				 * [tRESTClient_1 end ] stop
				 */

				/**
				 * [tLogRow_1 end ] start
				 */

				currentComponent = "tLogRow_1";

//////
//////
				globalMap.put("tLogRow_1_NB_LINE", nb_line_tLogRow_1);

///////////////////////    			

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
				}

				ok_Hash.put("tLogRow_1", true);
				end_Hash.put("tLogRow_1", System.currentTimeMillis());

				/**
				 * [tLogRow_1 end ] stop
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
				 * [tFileInputXML_1 finally ] start
				 */

				currentComponent = "tFileInputXML_1";

				/**
				 * [tFileInputXML_1 finally ] stop
				 */

				/**
				 * [tRESTClient_1 finally ] start
				 */

				currentComponent = "tRESTClient_1";

				/**
				 * [tRESTClient_1 finally ] stop
				 */

				/**
				 * [tLogRow_1 finally ] start
				 */

				currentComponent = "tLogRow_1";

				/**
				 * [tLogRow_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputXML_1_SUBPROCESS_STATE", 1);
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
		final jRestClientPost jRestClientPostClass = new jRestClientPost();

		int exitCode = jRestClientPostClass.runJobInTOS(args);

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
			java.io.InputStream inContext = jRestClientPost.class.getClassLoader()
					.getResourceAsStream("projet_esb_adda/jrestclientpost_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = jRestClientPost.class.getClassLoader()
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
			tFileInputXML_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputXML_1) {
			globalMap.put("tFileInputXML_1_SUBPROCESS_STATE", -1);

			e_tFileInputXML_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : jRestClientPost");
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
 * 62420 characters generated by Talend Open Studio for ESB on the 7 mars 2024 à
 * 01:03:16 CET
 ************************************************************************************************/