package org.codehaus.groovy.grails.support.encoding;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DefaultCodecIdentifier implements CodecIdentifier {
    private String codecName;
    private Set<String> codecAliases;
    
    public DefaultCodecIdentifier(String codecName) {
        this(codecName, (Set<String>)null);
    }
    
    public DefaultCodecIdentifier(String codecName, String... codecAliases) {
        this(codecName, (Set<String>)(codecAliases != null ? new HashSet<String>(Arrays.asList(codecAliases)) : null));
    }

    public DefaultCodecIdentifier(String codecName, Set<String> codecAliases) {
        this.codecName = codecName;
        this.codecAliases = codecAliases != null ? Collections.unmodifiableSet(codecAliases) : null;
    }

    public String getCodecName() {
        return codecName;
    }

    public Set<String> getCodecAliases() {
        return codecAliases;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codecAliases == null) ? 0 : codecAliases.hashCode());
        result = prime * result + ((codecName == null) ? 0 : codecName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultCodecIdentifier other = (DefaultCodecIdentifier)obj;
        if (codecAliases == null) {
            if (other.codecAliases != null)
                return false;
        }
        else if (!codecAliases.equals(other.codecAliases))
            return false;
        if (codecName == null) {
            if (other.codecName != null)
                return false;
        }
        else if (!codecName.equals(other.codecName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DefaultCodecIdentifier [codecName=" + codecName + ", codecAliases=" + codecAliases + "]";
    }

    public boolean isEquivalent(CodecIdentifier other) {
        if(this.codecName.equals(other.getCodecName())) {
            return true;
        } else if(this.codecAliases != null && this.codecAliases.contains(other.getCodecName())){
            return true;
        } else if(other.getCodecAliases() != null && other.getCodecAliases().contains(this.codecName)) {
            return true;
        }
        return false;
    }
}
