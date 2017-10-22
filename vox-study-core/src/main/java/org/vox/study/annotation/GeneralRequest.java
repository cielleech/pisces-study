package org.vox.study.annotation;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

public abstract class GeneralRequest {
    public String getRequestUrl() {
        SortedMap<String, String> map = new TreeMap<>();

        Field[] fields = getClass().getDeclaredFields();

        for (Field field : fields) {
            HttpParam param = field.getAnnotation(HttpParam.class);
            String name = param.value();
            if (StringUtils.isBlank(param.value())) {
                name = field.getName();
            }

            try {
                String value = "";
                field.setAccessible(true);
                if (field.get(this).getClass().isAssignableFrom(Collection.class)) {
                    Collection<?> collection = (Collection<?>) field.get(this);

                    value = StringUtils.join(collection, ",");
                } else {
                    value = field.get(this).toString();
                }

                value = field.get(this).toString();
                map.put(name, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (Entry<String, String> entry : map.entrySet()) {
            if (index > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }

        return sb.toString();
    }
}
