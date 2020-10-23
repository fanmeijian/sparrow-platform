package com.ywsoft.standalone.framework;

import org.apache.ignite.IgniteCheckedException;
import org.apache.ignite.internal.marshaller.optimized.OptimizedMarshaller;
import org.apache.ignite.lang.IgnitePredicate;
import org.apache.ignite.marshaller.Marshaller;
import org.apache.ignite.marshaller.MarshallerContext;
import org.apache.ignite.marshaller.jdk.JdkMarshaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyMarshaller {

	@Bean
	public Marshaller createMarshaller() throws IgniteCheckedException {
		Marshaller marsh = new OptimizedMarshaller();
		marsh.setContext(new MarshallerContext() {

			@Override
			public Class getClass(int id, ClassLoader ldr) {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean isSystemType(String typeName) {
				return false;
			}

			@Override
			public boolean registerClassName(byte platformId, int typeId, String clsName)
					throws IgniteCheckedException {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean registerClassNameLocally(byte platformId, int typeId, String clsName)
					throws IgniteCheckedException {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String getClassName(byte platformId, int typeId)
					throws ClassNotFoundException, IgniteCheckedException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public IgnitePredicate<String> classNameFilter() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public JdkMarshaller jdkMarshaller() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		return marsh;
	}
	
}
