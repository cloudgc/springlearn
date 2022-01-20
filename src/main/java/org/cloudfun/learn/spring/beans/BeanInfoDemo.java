package org.cloudfun.learn.spring.beans;

import java.beans.*;
import java.util.stream.Stream;

public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        System.out.println(beanInfo);

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {

            System.out.println(propertyDescriptor);

            Class<?> propertyType = propertyDescriptor.getPropertyType();

            propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);

            PropertyEditor propertyEditor = propertyDescriptor.createPropertyEditor(propertyType);

        });

    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            super.setAsText(text);
        }
    }


}
