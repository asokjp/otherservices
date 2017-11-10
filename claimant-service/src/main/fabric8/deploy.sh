SCRIPTDIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
kubectl delete -f $SCRIPTDIR/src/main/fabric8/claimantservice.yaml
gcloud container images delete $1
docker push $1
istioctl kube-inject -f $SCRIPTDIR/src/main/fabric8/claimantservice.yaml --includeIPRanges=10.60.0.0/14,10.63.240.0/20 > final.yaml
kubectl apply -f final.yaml
rm -f final.yaml
istioctl mixer rule create claimantservice.default.svc.cluster.local claimantservice.default.svc.cluster.local -f $SCRIPTDIR/src/main/fabric8/telemeteryrule.yaml