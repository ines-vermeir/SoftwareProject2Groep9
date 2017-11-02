/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.usertype;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.Type;

/**
 * A <tt>UserType</tt> that may be dereferenced in a query.
 * This interface allows a custom type to define "properties".
 * These need not necessarily correspond to physical JavaBeans
 * style properties.<br>
 * <br>
 * A <tt>CompositeUserType</tt> may be used in almost every way
 * that a component may be used. It may even contain many-to-one
 * associations.<br>
 * <br>
 * Implementors must be immutable and must declare a public
 * default constructor.<br>
 * <br>
 * Unlike <tt>UserType</tt>, cacheability does not depend upon
 * serializability. Instead, <tt>assemble()</tt> and
 * <tt>disassemble</tt> provide conversion to/from a cacheable
 * representation.
 *
 * @see UserType for more simple cases
 * @see org.hibernate.type.Type
 * @author Gavin King
 */
public interface CompositeUserType {

	/**
	 * Get the "property names" that may be used in a
	 * query.
	 *
	 * @return an array of "property names"
	 */
	String[] getPropertyNames();

	/**
	 * Get the corresponding "property types".
	 *
	 * @return an array of Hibernate types
	 */
	Type[] getPropertyTypes();

	/**
	 * Get the value of a property.
	 *
	 * @param component an instance of class mapped by this "type"
	 * @param property
	 * @return the property value
	 * @throws HibernateException
	 */
	Object getPropertyValue(Object component, int property) throws HibernateException;

	/**
	 * Set the value of a property.
	 *
	 * @param component an instance of class mapped by this "type"
	 * @param property
	 * @param value the value to set
	 * @throws HibernateException
	 */
	void setPropertyValue(Object component, int property, Object value) throws HibernateException;

	/**
	 * The class returned by <tt>nullSafeGet()</tt>.
	 *
	 * @return Class
	 */
	Class returnedClass();

	/**
	 * Compare two instances of the class mapped by this type for persistence "equality".
	 * Equality of the persistent state.
     *
	 * @throws HibernateException
	 */
	boolean equals(Object x, Object y) throws HibernateException;
	
	/**
	 * Get a hashcode for the instance, consistent with persistence "equality"
	 */
	int hashCode(Object x) throws HibernateException;

	/**
	 * Retrieve an instance of the mapped class from a JDBC resultset. Implementors
	 * should handle possibility of null values.
	 *
	 * @param rs a JDBC result set
	 * @param names the column names
	 * @param session
	 * @param owner the containing entity
	 * @return Object
	 * @throws HibernateException
	 * @throws SQLException
	 */
	Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException;

	/**
	 * Write an instance of the mapped class to a prepared statement. Implementors
	 * should handle possibility of null values. A multi-column type should be written
	 * to parameters starting from <tt>index</tt>.
	 *
	 * @param st a JDBC prepared statement
	 * @param value the object to write
	 * @param index statement parameter index
	 * @param session
	 * @throws HibernateException
	 * @throws SQLException
	 */
	void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException;

	/**
	 * Return a deep copy of the persistent state, stopping at entities and at collections.
	 *
	 * @param value generally a collection element or entity field
	 * @return Object a copy
	 * @throws HibernateException
	 */
	Object deepCopy(Object value) throws HibernateException;

	/**
	 * Check if objects of this type mutable.
	 *
	 * @return boolean
	 */
	boolean isMutable();

	/**
	 * Transform the object into its cacheable representation. At the very least this
	 * method should perform a deep copy. That may not be enough for some implementations,
	 * however; for example, associations must be cached as identifier values. (optional
	 * operation)
	 *
	 * @param value the object to be cached
	 * @param session
	 * @return a cachable representation of the object
	 * @throws HibernateException
	 */
	Serializable disassemble(Object value, SharedSessionContractImplementor session) throws HibernateException;

	/**
	 * Reconstruct an object from the cacheable representation. At the very least this
	 * method should perform a deep copy. (optional operation)
	 *
	 * @param cached the object to be cached
	 * @param session
	 * @param owner the owner of the cached object
	 * @return a reconstructed object from the cachable representation
	 * @throws HibernateException
	 */
	Object assemble(Serializable cached, SharedSessionContractImplementor session, Object owner) throws HibernateException;

	/**
	 * During merge, replace the existing (target) value in the entity we are merging to
	 * with a new (original) value from the detached entity we are merging. For immutable
	 * objects, or null values, it is safe to simply return the first parameter. For
	 * mutable objects, it is safe to return a copy of the first parameter. However, since
	 * composite user types often define component values, it might make sense to recursively
	 * replace component values in the target object.
	 *
	 * @throws HibernateException
	 */
	Object replace(Object original, Object target, SharedSessionContractImplementor session, Object owner) throws HibernateException;
}
