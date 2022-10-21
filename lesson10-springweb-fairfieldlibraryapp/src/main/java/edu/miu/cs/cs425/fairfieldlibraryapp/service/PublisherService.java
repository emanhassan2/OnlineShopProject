package edu.miu.cs.cs425.fairfieldlibraryapp.service;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Publisher;

import java.util.List;

public interface PublisherService {

    public List<Publisher> getPublishers();
    public Publisher addNewPublisher(Publisher publisher);
    public Publisher updatePublisher(Integer PublisherId, Publisher editedPublisher);
    void  deletePublisher(Integer PublisherId);
    public Publisher editPublisher(Publisher publisher);
}
