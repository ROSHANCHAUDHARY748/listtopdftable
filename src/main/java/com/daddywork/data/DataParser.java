package com.daddywork.data;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface DataParser {

    List<Map<String, String>> convertToList(InputStream inputStream) throws Exception;

}
