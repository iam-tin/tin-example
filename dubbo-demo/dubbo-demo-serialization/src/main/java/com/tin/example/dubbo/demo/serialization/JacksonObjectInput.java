/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tin.example.dubbo.demo.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.serialize.ObjectInput;

import java.io.*;
import java.lang.reflect.Type;

/**
 * title: JacksonSerialization
 * <p>
 * description: Jackson object input implementation
 *
 * @author tin @公众号【看点代码再上班】 on 2022/3/3 下午18:56
 */
@Slf4j
public class JacksonObjectInput implements ObjectInput {

    private final BufferedReader reader;
    private ObjectMapper objectMapper;

    public JacksonObjectInput(InputStream in) {
        this(new InputStreamReader(in));
    }

    public JacksonObjectInput(Reader reader) {
        this.reader = new BufferedReader(reader);
        objectMapper = new ObjectMapper();
    }

    @Override
    public boolean readBool() throws IOException {
        return read(boolean.class);
    }

    @Override
    public byte readByte() throws IOException {
        return read(byte.class);
    }

    @Override
    public short readShort() throws IOException {
        return read(short.class);
    }

    @Override
    public int readInt() throws IOException {
        return read(int.class);
    }

    @Override
    public long readLong() throws IOException {
        return read(long.class);
    }

    @Override
    public float readFloat() throws IOException {
        return read(float.class);
    }

    @Override
    public double readDouble() throws IOException {
        return read(double.class);
    }

    @Override
    public String readUTF() throws IOException {
        return read(String.class);
    }

    @Override
    public byte[] readBytes() throws IOException {
        return readLine().getBytes();
    }

    @Override
    public Object readObject() throws IOException, ClassNotFoundException {
        String json = readLine();
        return objectMapper.readValue(json, Object.class);
    }

    @Override
    public <T> T readObject(Class<T> cls) throws IOException, ClassNotFoundException {
        return read(cls);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T readObject(Class<T> cls, Type type) throws IOException, ClassNotFoundException {
        String json = readLine();
        return objectMapper.readValue(json, cls);
    }

    private String readLine() throws IOException, EOFException {
        String line = reader.readLine();
        if (line == null || line.trim().length() == 0) {
            throw new EOFException();
        }
        log.debug("jackson read line... line:{}", line);
        return line;
    }

    private <T> T read(Class<T> cls) throws IOException {
        String json = readLine();
        return objectMapper.readValue(json, cls);
    }
}
