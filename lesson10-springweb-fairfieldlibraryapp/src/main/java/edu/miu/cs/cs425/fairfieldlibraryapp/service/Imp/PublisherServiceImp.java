package edu.miu.cs.cs425.fairfieldlibraryapp.service.Imp;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibraryapp.repository.PublisherRepository;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImp implements PublisherService {
    @Autowired
    public PublisherRepository publisherRepository;
    @Override
    public List<Publisher> getPublishers() {
         return publisherRepository.findAll();
    }
   /* public List<Publisher> mapIterableToList (Iterable<Publisher> publishers) {

    }
*/
    @Override
    public Publisher addNewPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher updatePublisher(Integer PublisherId, Publisher editedPublisher) {
        var thePublisher = publisherRepository.findById(PublisherId).orElse(null);
        if(thePublisher != null) {
            thePublisher.setName(editedPublisher.getName());
            publisherRepository.save(thePublisher);
        }
        return thePublisher;
    }

    @Override
    public void deletePublisher(Integer PublisherId) {
        publisherRepository.deleteById(PublisherId);
    }

    @Override
    public Publisher editPublisher(Publisher publisher) {
       return publisherRepository.save(publisher);
    }
}
