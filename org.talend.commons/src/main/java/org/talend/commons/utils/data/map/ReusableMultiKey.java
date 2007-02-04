// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006 Talend - www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.commons.utils.data.map;


/**
 * DOC amaumont  class global comment. Detailled comment
 * <br/>
 *
 * $Id$
 *
 */
/*
 *  Copyright 2003-2004 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import java.io.Serializable;
import java.util.Arrays;

import org.talend.commons.i18n.internal.Messages;

/** 
 * A <code>MultiKey</code> allows multiple map keys to be merged together.
 * <p>
 * The purpose of this class is to avoid the need to write code to handle
 * maps of maps. An example might be the need to lookup a filename by 
 * key and locale. The typical solution might be nested maps. This class
 * can be used instead by creating an instance passing in the key and locale.
 * <p>
 * Example usage:
 * <pre>
 * // populate map with data mapping key+locale to localizedText
 * Map map = new HashMap();
 * MultiKey multiKey = new MultiKey(key, locale);
 * map.put(multiKey, localizedText);
 *
 * // later retireve the localized text
 * MultiKey multiKey = new MultiKey(key, locale);
 * String localizedText = (String) map.get(multiKey);
 * </pre>
 * 
 * @since Commons Collections 3.0
 * @version $Revision: 1 $ $Date: 2006-09-29 17:06:40 +0000 (ven., 29 sept. 2006) $
 * 
 * @author Howard Lewis Ship
 * @author Stephen Colebourne
 */
public class ReusableMultiKey implements Serializable {
    // This class could implement List, but that would confuse it's purpose

    /** Serialisation version */
    private static final long serialVersionUID = 4465448607415788805L;

    /** The individual keys */
    private Object[] keys;
    /** The cached hashCode */
    private int hashCode;
    
    /**
     * Constructor taking two keys.
     * <p>
     * The keys should be immutable
     * If they are not then they must not be changed after adding to the MultiKey.
     * 
     * @param key1  the first key
     * @param key2  the second key
     */
    public ReusableMultiKey(Object key1, Object key2) {
        this(new Object[] {key1, key2}, false);
    }
    
    /**
     * Constructor taking three keys.
     * <p>
     * The keys should be immutable
     * If they are not then they must not be changed after adding to the MultiKey.
     * 
     * @param key1  the first key
     * @param key2  the second key
     * @param key3  the third key
     */
    public ReusableMultiKey(Object key1, Object key2, Object key3) {
        this(new Object[] {key1, key2, key3}, false);
    }
    
    /**
     * Constructor taking four keys.
     * <p>
     * The keys should be immutable
     * If they are not then they must not be changed after adding to the MultiKey.
     * 
     * @param key1  the first key
     * @param key2  the second key
     * @param key3  the third key
     * @param key4  the fourth key
     */
    public ReusableMultiKey(Object key1, Object key2, Object key3, Object key4) {
        this(new Object[] {key1, key2, key3, key4}, false);
    }
    
    /**
     * Constructor taking five keys.
     * <p>
     * The keys should be immutable
     * If they are not then they must not be changed after adding to the MultiKey.
     * 
     * @param key1  the first key
     * @param key2  the second key
     * @param key3  the third key
     * @param key4  the fourth key
     * @param key5  the fifth key
     */
    public ReusableMultiKey(Object key1, Object key2, Object key3, Object key4, Object key5) {
        this(new Object[] {key1, key2, key3, key4, key5}, false);
    }
    
    /**
     * Constructor taking an array of keys which is cloned.
     * <p>
     * The keys should be immutable
     * If they are not then they must not be changed after adding to the MultiKey.
     * <p>
     * This is equivalent to <code>new MultiKey(keys, true)</code>.
     *
     * @param keys  the array of keys, not null
     * @throws IllegalArgumentException if the key array is null
     */
    public ReusableMultiKey(Object[] keys) {
        this(keys, true);
    }
    
    /**
     * Constructor taking an array of keys which is cloned.
     * <p>
     * The keys should be immutable
     * If they are not then they must not be changed after adding to the MultiKey.
     * <p>
     * This is equivalent to <code>new MultiKey(keys, true)</code>.
     *
     * @param keys  the array of keys, not null
     * @throws IllegalArgumentException if the key array is null
     */
    public ReusableMultiKey() {
        super();
    }
    
    /**
     * Constructor taking an array of keys, optionally choosing whether to clone.
     * <p>
     * <b>If the array is not cloned, then it must not be modified.</b>
     * <p>
     * This method is public for performance reasons only, to avoid a clone.
     * The hashcode is calculated once here in this method.
     * Therefore, changing the array passed in would not change the hashcode but
     * would change the equals method, which is a bug.
     * <p>
     * This is the only fully safe usage of this constructor, as the object array
     * is never made available in a variable:
     * <pre>
     * new MultiKey(new Object[] {...}, false);
     * </pre>
     * <p>
     * The keys should be immutable
     * If they are not then they must not be changed after adding to the MultiKey.
     *
     * @param keys  the array of keys, not null
     * @param makeClone  true to clone the array, false to assign it
     * @throws IllegalArgumentException if the key array is null
     * @since Commons Collections 3.1
     */
    public ReusableMultiKey(Object[] keys, boolean makeClone) {
        super();
        setKeys(keys, makeClone);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Gets a clone of the array of keys.
     * <p>
     * The keys should be immutable
     * If they are not then they must not be changed.
     * 
     * @return the individual keys
     */
    public Object[] getKeys() {
        return (Object[]) keys.clone();
    }
    
    /**
     * Gets the key at the specified index.
     * <p>
     * The key should be immutable.
     * If it is not then it must not be changed.
     * 
     * @param index  the index to retrieve
     * @return the key at the index
     * @throws IndexOutOfBoundsException if the index is invalid
     * @since Commons Collections 3.1
     */
    public Object getKey(int index) {
        return keys[index];
    }
    
    /**
     * Gets the size of the list of keys.
     * 
     * @return the size of the list of keys
     * @since Commons Collections 3.1
     */
    public int size() {
        return keys.length;
    }
    
    //-----------------------------------------------------------------------
    /**
     * Compares this object to another.
     * <p>
     * To be equal, the other object must be a <code>MultiKey</code> with the
     * same number of keys which are also equal.
     * 
     * @param other  the other object to compare to
     * @return true if equal
     */
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ReusableMultiKey) {
            ReusableMultiKey otherMulti = (ReusableMultiKey) other;
            return Arrays.equals(keys, otherMulti.keys);
        }
        return false;
    }

    /**
     * Gets the combined hash code that is computed from all the keys.
     * <p>
     * This value is computed once and then cached, so elements should not
     * change their hash codes once created (note that this is the same 
     * constraint that would be used if the individual keys elements were
     * themselves {@link java.util.Map Map} keys.
     * 
     * @return the hash code
     */
    public int hashCode() {
        return hashCode;
    }

    /**
     * Gets a debugging string version of the key.
     * 
     * @return a debugging string
     */
    public String toString() {
        return "MultiKey" + Arrays.asList(keys).toString();
    }

    public void setKeys(Object[] keys) {
        setKeys(keys, false);
    }
        
    public void setKeys(Object[] keys, boolean makeClone) {
        if (keys == null) {
            throw new IllegalArgumentException(Messages.getString("ReusableMultiKey.Keys.BeNull")); //$NON-NLS-1$
        }
        if (makeClone) {
            this.keys = (Object[]) keys.clone();
        } else {
            this.keys = keys;
        }
        
        int total = 0;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                total ^= keys[i].hashCode();
            }
        }
        hashCode = total;
    }
    
}

