package ma.grpc.service;

import io.grpc.stub.StreamObserver;
import ma.grpc.stubs.Bank;
import ma.grpc.stubs.BankServiceGrpc;

public class BankGrpcService extends BankServiceGrpc.BankServiceImplBase {
    // Implement the service methods here
    @Override
    public void convert(Bank.ConvertCurrencyRequest request, StreamObserver<Bank.ConvertCurrencyResponse> responseObserver) {
        String currencyFrom = request.getCurrencyFrom();
        String currencyTo = request.getCurrencyTo();
        double amount = request.getAmount();

        Bank.ConvertCurrencyResponse response = Bank.ConvertCurrencyResponse.newBuilder()
                .setCurrencyFrom(currencyFrom)
                .setCurrencyTo(currencyTo)
                .setAmount(amount)
                .setResult(amount * 11.4)
                .build();
        // send item to client
        responseObserver.onNext(response);
        // on completed means that the server has finished sending data
        responseObserver.onCompleted();
    }

    @Override
    public void getCurrentCurrencyStream(Bank.ConvertCurrencyResponse request, StreamObserver<Bank.ConvertCurrencyResponse> responseObserver) {
        super.getCurrentCurrencyStream(request, responseObserver);
    }

    @Override
    public StreamObserver<Bank.ConvertCurrencyRequest> performStream(StreamObserver<Bank.ConvertCurrencyResponse> responseObserver) {
        return super.performStream(responseObserver);
    }

    @Override
    public StreamObserver<Bank.ConvertCurrencyRequest> fullCurrencyStream(StreamObserver<Bank.ConvertCurrencyResponse> responseObserver) {
        return super.fullCurrencyStream(responseObserver);
    }
}
