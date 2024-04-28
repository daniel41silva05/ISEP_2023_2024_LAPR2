package pprog.domain;

public enum IdDocType {
    TAXPAYER_NUMBER, CITIZEN_NUMBER, PASSPORT;
        @Override
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
        }
}


