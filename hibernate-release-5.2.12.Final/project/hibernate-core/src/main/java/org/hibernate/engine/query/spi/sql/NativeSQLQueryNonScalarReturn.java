/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.engine.query.spi.sql;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;

/**
 * Represents the base information for a non-scalar return defined as part of
 * a native sql query.
 *
 * @author Steve Ebersole
 */
public abstract class NativeSQLQueryNonScalarReturn implements NativeSQLQueryReturn, Serializable {
	private final String alias;
	private final LockMode lockMode;
	private final Map<String,String[]> propertyResults = new HashMap<String,String[]>();
	private final int hashCode;

	/**
	 * Constructs some form of non-scalar return descriptor
	 *
	 * @param alias The result alias
	 * @param propertyResults Any user-supplied column->property mappings
	 * @param lockMode The lock mode to apply to the return.
	 */
	protected NativeSQLQueryNonScalarReturn(String alias, Map<String,String[]> propertyResults, LockMode lockMode) {
		this.alias = alias;
		if ( alias == null ) {
			throw new HibernateException("alias must be specified");
		}
		this.lockMode = lockMode;
		if ( propertyResults != null ) {
			this.propertyResults.putAll( propertyResults );
		}
		this.hashCode = determineHashCode();
	}

	private int determineHashCode() {
		int result = alias != null ? alias.hashCode() : 0;
		result = 31 * result + ( getClass().getName().hashCode() );
		result = 31 * result + ( lockMode != null ? lockMode.hashCode() : 0 );
		result = 31 * result + propertyResults.hashCode();
		return result;
	}

	/**
	 * Retrieve the defined result alias
	 *
	 * @return The result alias.
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Retrieve the lock-mode to apply to this return
	 *
	 * @return The lock mode
	 */
	public LockMode getLockMode() {
		return lockMode;
	}

	/**
	 * Retrieve the user-supplied column->property mappings.
	 *
	 * @return The property mappings.
	 */
	public Map<String,String[]> getPropertyResultsMap() {
		return Collections.unmodifiableMap( propertyResults );
	}

	@Override
	public int hashCode() {
		return hashCode;
	}

	@Override
	@SuppressWarnings("RedundantIfStatement")
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}

		final NativeSQLQueryNonScalarReturn that = (NativeSQLQueryNonScalarReturn) o;

		if ( alias != null ? !alias.equals( that.alias ) : that.alias != null ) {
			return false;
		}
		if ( lockMode != null ? !lockMode.equals( that.lockMode ) : that.lockMode != null ) {
			return false;
		}
		if ( !propertyResults.equals( that.propertyResults ) ) {
			return false;
		}

		return true;
	}

	@Override
	public void traceLog(TraceLogger logger) {
		if ( NativeSQLQueryRootReturn.class.isInstance( this ) ) {
			logger.writeLine( "Entity(...)" );
		}
		else if ( NativeSQLQueryCollectionReturn.class.isInstance( this ) ) {
			logger.writeLine( "Collection(...)" );
		}
		else if ( NativeSQLQueryJoinReturn.class.isInstance( this ) ) {
			logger.writeLine( "Join(...)" );
		}
		else {
			logger.writeLine( getClass().getName() + "(...)" );
		}
	}
}
