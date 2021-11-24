/*
 * Copyright 2014-2021 Sayi
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
package com.deepoove.poi.data;

import java.io.File;
import java.io.InputStream;

import com.deepoove.poi.util.ByteUtils;

/**
 * Factory method to create {@link AttachmentRenderData}
 * 
 * @author Sayi
 *
 */
public class Attachments {
    private Attachments() {
    }

    public static AttachmentBuilder ofLocal(String src, AttachmentType fileType) {
        return ofBytes(ByteUtils.getLocalByteArray(new File(src)), fileType);
    }

    public static AttachmentBuilder ofStream(InputStream inputStream, AttachmentType fileType) {
        return ofBytes(ByteUtils.toByteArray(inputStream), fileType);
    }

    public static AttachmentBuilder ofBytes(byte[] bytes, AttachmentType fileType) {
        return new AttachmentBuilder(bytes, fileType);
    }

    /**
     * Builder to build {@link AttachmentRenderData}
     *
     */
    public static class AttachmentBuilder implements RenderDataBuilder<AttachmentRenderData> {

        AttachmentRenderData data;

        private AttachmentBuilder(byte[] bytes, AttachmentType fileType) {
            data = new AttachmentRenderData(bytes);
            data.setFileType(fileType);
        }

        @Override
        public AttachmentRenderData create() {
            return data;
        }
    }

}
