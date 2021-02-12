package fr.upec.episen.mounir;
import fr.upec.episen.mounir.proto.OwnerGrpc;
import fr.upec.episen.mounir.proto.OwnerNameReply;
import fr.upec.episen.mounir.proto.OwnerNameRequest;
import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;

@Singleton
public class OwnerGrpcService extends OwnerGrpc.OwnerImplBase{

    @Override
    public void getOwnerName(OwnerNameRequest request, StreamObserver<OwnerNameReply> responseObserver) {

        String identification = request.getIdentification();
        String name= "";

        switch (identification) {
            case "AB-123-CD":
                name = "Zinedine Zidane";
                break;
            case "MC-007-CM":
                name = "Niusha Pakseresht ";
                break;
            default:
                name = "inconnu";
                break;
        }

        responseObserver.onNext(OwnerNameReply
                .newBuilder()
                .setName(name)
                .build()
        );

        responseObserver.onCompleted();
    }
}
