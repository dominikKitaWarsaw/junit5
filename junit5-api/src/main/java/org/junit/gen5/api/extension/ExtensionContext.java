/*
 * Copyright 2015-2016 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.gen5.api.extension;

import java.lang.reflect.AnnotatedElement;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * {@code ExtensionContext} encapsulates the <em>context</em> in which the
 * current test or container is being executed.
 *
 * <p>{@link Extension Extensions} are provided an instance of
 * {@code ExtensionContext} to perform their work.
 *
 * @since 5.0
 */
public interface ExtensionContext {

	void publishReportEntry(Map<String, String> entry);

	Optional<ExtensionContext> getParent();

	String getUniqueId();

	/**
	 * Get the name for the current test or container.
	 *
	 * <p>The <em>name</em> is typically a technical name of the underlying
	 * artifact &mdash; for example, the fully qualified name of a Java class,
	 * the canonical absolute path to a file in the file system, etc.
	 *
	 * @see #getDisplayName()
	 */
	String getName();

	/**
	 * Get the display name for the current test or container.
	 *
	 * <p>Display names are typically used for test reporting in IDEs and
	 * build tools and may contain spaces, special characters, and even emoji.
	 */
	String getDisplayName();

	Class<?> getTestClass();

	AnnotatedElement getElement();

	// Storing methods. Not done yet.

	Object get(Object key);

	void put(Object key, Object value);

	Object getOrComputeIfAbsent(Object key, Function<Object, Object> defaultCreator);

	void remove(Object key);

	// Attributes will be removed when storing methods are done

	Object getAttribute(String key);

	void putAttribute(String key, Object value);

	Object removeAttribute(String key);

}
