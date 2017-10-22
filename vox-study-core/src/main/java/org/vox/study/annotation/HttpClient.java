package org.vox.study.annotation;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class HttpClient {
    public static String execute(GeneralRequest request) {
        Field[] fields = request.getClass().getDeclaredFields();

        SortedMap<String, String> map = new TreeMap<>();

        for (Field field : fields) {
            HttpParam param = field.getAnnotation(HttpParam.class);
            String name = param.value();
            if (StringUtils.isBlank(param.value())) {
                name = field.getName();
            }

            try {
                String value = "";
                field.setAccessible(true);
                if (field.get(request).getClass().isAssignableFrom(Collection.class)) {
                    Collection<?> collection = (Collection<?>) field.get(request);

                    value = StringUtils.join(collection, ",");
                } else {
                    value = field.get(request).toString();
                }

                value = field.get(request).toString();
                map.put(name, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (index > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return sb.toString();
    }
}
