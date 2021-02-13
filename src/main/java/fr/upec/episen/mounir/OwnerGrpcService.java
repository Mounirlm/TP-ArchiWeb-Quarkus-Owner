package fr.upec.episen.mounir;
import fr.upec.episen.mounir.proto.*;
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


/*
    @Override
    public void setOwnerName(ClientRequest request, StreamObserver<ClientNameResponse> responseObserver) {

        String identification = request.getIdentification();

        String name = "";

        switch (identification) {
            case "AB-123-CD":
                name = request.getName();
                break;
            case "MC-007-CM":
                name = request.getName();
                break;
            default:
                name = "inconnu";
                break;
        }

        responseObserver.onNext(ClientNameResponse
                .newBuilder()
                .setName(name)
                .build()
        );

        responseObserver.onCompleted();
    }

 */
}
