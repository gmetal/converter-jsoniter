/**
 * Copyright (C) 2017 - gmetal <gmetaxas@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gr.gmetal.jsoniter;

import com.jsoniter.JsonIterator;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

class JsoniterResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    public static final int BUF_SIZE = 512;

    private Class<T> mCls;

    public JsoniterResponseBodyConverter(Class<T> cls) {

        mCls = cls;
    }

    @Override
    public T convert(final ResponseBody value) throws IOException {

        final JsonIterator parsedValue = JsonIterator.parse(value.byteStream(), BUF_SIZE);

        return parsedValue.read(mCls);
    }
}
