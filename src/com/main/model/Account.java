    package com.main.model;

    import java.time.LocalDateTime;

    public class Account {
        private int id;
        private String name;
        private Double pay;
        private LocalDateTime lastUpdateDateTime;
        private int idCurrency;
        private String type;


        public Account(int id, String name, Double pay, LocalDateTime lastUpdateDateTime, int idCurrency, String type) {
            this.id = id;
            this.name = name;
            this.pay = pay;
            this.lastUpdateDateTime = lastUpdateDateTime;
            this.idCurrency = idCurrency;
            this.type = type;
        }

        public Account(int id, String name, Double pay, int idCurrency, String type) {
            this.id = id;
            this.name = name;
            this.pay = pay;
            this.idCurrency = idCurrency;
            this.type = type;
        }

        public Account() {

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getPay() {
            return pay;
        }

        public void setPay(Double pay) {
            this.pay = pay;
        }

        public LocalDateTime getLastUpdateDateTime() {
            return lastUpdateDateTime;
        }

        public void setLastUpdateDateTime(LocalDateTime lastUpdateDateTime) {
            this.lastUpdateDateTime = lastUpdateDateTime;
        }

        public int getIdCurrency() {
            return idCurrency;
        }

        public void setIdCurrency(int idCurrency) {
            this.idCurrency = idCurrency;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", pay=" + pay +
                    ", lastUpdateDateTime=" + lastUpdateDateTime +
                    ", idCurrency=" + idCurrency +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
