/*
 * Copyright (c) 2014, Francis Galiegue (fgaliegue@gmail.com)
 *
 * This software is dual-licensed under:
 *
 * - the Lesser General Public License (LGPL) version 3.0 or, at your option, any
 *   later version;
 * - the Apache Software License (ASL) version 2.0.
 *
 * The text of both licenses is available under the src/resources/ directory of
 * this project (under the names LGPL-3.0.txt and ASL-2.0.txt respectively).
 *
 * Direct link to the sources:
 *
 * - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
 * - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
 */

package com.github.fge.ftpfs;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileStore;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;

public final class FtpFileStore
    extends FileStore
{
    private final String name;

    public FtpFileStore(final URI uri)
    {
        name = uri.toString();
    }

    @Override
    public String name()
    {
        return name;
    }

    @Override
    public String type()
    {
        return "ftp";
    }

    @Override
    public boolean isReadOnly()
    {
        return true;
    }

    @Override
    public long getTotalSpace()
        throws IOException
    {
        return Long.MAX_VALUE;
    }

    @Override
    public long getUsableSpace()
        throws IOException
    {
        return Long.MAX_VALUE;
    }

    @Override
    public long getUnallocatedSpace()
        throws IOException
    {
        return Long.MAX_VALUE;
    }

    @Override
    public boolean supportsFileAttributeView(
        final Class<? extends FileAttributeView> type)
    {
        return type == BasicFileAttributeView.class;
    }

    @Override
    public boolean supportsFileAttributeView(final String name)
    {
        return "basic".equals(name);
    }

    @Override
    public <V extends FileStoreAttributeView> V getFileStoreAttributeView(
        final Class<V> type)
    {
        return null;
    }

    @Override
    public Object getAttribute(final String attribute)
        throws IOException
    {
        throw new UnsupportedOperationException("no attributes are supported");
    }
}
