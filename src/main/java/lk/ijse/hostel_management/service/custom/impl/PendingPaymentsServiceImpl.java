package lk.ijse.hostel_management.service.custom.impl;

import lk.ijse.hostel_management.Projection.CustomeProjection;
import lk.ijse.hostel_management.config.SessionFactoryConfig;
import lk.ijse.hostel_management.dto.PendingPaymentsDTO;
import lk.ijse.hostel_management.repository.RepositoryFactory;
import lk.ijse.hostel_management.repository.custom.PendingPaymentsRepository;
import lk.ijse.hostel_management.service.custom.PendingPaymentsService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PendingPaymentsServiceImpl implements PendingPaymentsService<PendingPaymentsDTO> {
    PendingPaymentsRepository pendingPaymentsRepository= RepositoryFactory.getInstance().getRepostory(RepositoryFactory.repositoryTypes.pendingPayments);
    @Override
    public List<PendingPaymentsDTO> getAllPendingPayments() {
        Session session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try {
            pendingPaymentsRepository.setSession(session);
            List<CustomeProjection> list=pendingPaymentsRepository.getAllPendingPayments();
            List<PendingPaymentsDTO> paymentsDTOList=new ArrayList<>();

            for (CustomeProjection customeProjection : list) {
                paymentsDTOList.add(new PendingPaymentsDTO(
                        customeProjection.getResId(),
                        customeProjection.getStudentId(),
                        customeProjection.getName(),
                        customeProjection.getContact()
                ));

            }
            transaction.commit();
            session.close();
            return paymentsDTOList;


        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            session.close();
            return null;
        }
     }


}
