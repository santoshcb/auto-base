package com.auto.base.util;
/*package com.spire.base.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Message;

@Provider
@Produces("application/x-protobuf")
@Consumes("application/x-protobuf")
public class ProtobufMessageBodyReaderWriter implements
MessageBodyReader<Message>, MessageBodyWriter<Message> {

	
	 * weak hash to hold the bytes for a given message
	 
	private Map<Object, byte[]> buffer = new WeakHashMap<Object, byte[]>();;

	public boolean isReadable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return Message.class.isAssignableFrom(type);
	}

	public Message readFrom(Class<Message> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
	throws IOException, WebApplicationException {
		try {
			Method newBuilder = type.getMethod("newBuilder");
			GeneratedMessage.Builder<?> builder = (GeneratedMessage.Builder<?>) newBuilder
			.invoke(type);
			return builder.mergeFrom(entityStream).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return Message.class.isAssignableFrom(type);
	}

	public long getSize(Message m, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			m.writeTo(baos);
		} catch (IOException e) {
			return -1;
		}
		byte[] bytes = baos.toByteArray();
		buffer.put(m, bytes);
		return bytes.length;
	}

	public void writeTo(Message m, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException,
			WebApplicationException {

		entityStream.write(buffer.remove(m));
	}

	public Message readFrom(
			Class<com.spire.base.util.Message> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}

*/