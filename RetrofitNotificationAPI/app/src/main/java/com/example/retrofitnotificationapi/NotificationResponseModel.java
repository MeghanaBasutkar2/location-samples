package com.example.retrofitnotificationapi;

public class NotificationResponseModel {

        private String canonical_ids;

        private String success;

        private String failure;

        private Results[] results;

        private String multicast_id;

        public String getCanonical_ids ()
        {
            return canonical_ids;
        }

        public void setCanonical_ids (String canonical_ids)
        {
            this.canonical_ids = canonical_ids;
        }

        public String getSuccess ()
        {
            return success;
        }

        public void setSuccess (String success)
        {
            this.success = success;
        }

        public String getFailure ()
        {
            return failure;
        }

        public void setFailure (String failure)
        {
            this.failure = failure;
        }

        public Results[] getResults ()
        {
            return results;
        }

        public void setResults (Results[] results)
        {
            this.results = results;
        }

        public String getMulticast_id ()
        {
            return multicast_id;
        }

        public void setMulticast_id (String multicast_id)
        {
            this.multicast_id = multicast_id;
        }

        @Override
        public String toString()
        {
            return "NotificationResponseModel [canonical_ids = "+canonical_ids+", success = "+success+", failure = "+failure+", results = "+results+", multicast_id = "+multicast_id+"]";
        }
}
