package ir.maktab.q1.model.repository;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class NamingStrategy extends PhysicalNamingStrategyStandardImpl {
    private final static String POSTFIX = "_TBL";
    private final static String PREFIX = "COL_";

    @Override
    public Identifier toPhysicalTableName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        if (identifier == null) {
            return null;
        }
        final String newName = identifier.getText() + POSTFIX;
        return Identifier.toIdentifier(newName);
    }

    @Override
    public Identifier toPhysicalColumnName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        if (identifier == null) {
            return null;
        }
        final String newName = PREFIX + identifier.getText();
        return Identifier.toIdentifier(newName);
    }

}

