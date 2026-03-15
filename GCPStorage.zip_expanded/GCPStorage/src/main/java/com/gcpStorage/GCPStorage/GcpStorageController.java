package com.gcpStorage.GCPStorage;

import java.nio.charset.StandardCharsets;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;

@RestController
@RequestMapping("/bucket")
public class GcpStorageController {

	// Define the logger manually
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(GcpStorageController.class);

	private final String bucketName = "shamimgcpbucket";
	@Autowired
	private Storage storage;

	@GetMapping("/test")
	public String testApi() {
		logger.info("Inside the testApi");
		return "test";
	}

	// 1. CREATE (POST)
    @PostMapping("/upload")
    public String createBlob(@RequestParam String fileName, @RequestParam String content) {
        BlobId blobId = BlobId.of(bucketName, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
        storage.create(blobInfo, content.getBytes(StandardCharsets.UTF_8));
        return "File '" + fileName + "' uploaded successfully!";
    }

    // 2. READ (GET)
    @GetMapping("/read")
    public String readBlob(@RequestParam String fileName) {
        Blob blob = storage.get(BlobId.of(bucketName, fileName));
        if (blob == null) return "File not found!";
        return new String(blob.getContent(), StandardCharsets.UTF_8);
    }

    // 3. UPDATE (PUT)
    @PutMapping("/update")
    public String updateBlob(@RequestParam String fileName, @RequestParam String newContent) {
        BlobId blobId = BlobId.of(bucketName, fileName);
        if (storage.get(blobId) == null) return "File does not exist to update!";
        
        storage.create(BlobInfo.newBuilder(blobId).build(), newContent.getBytes(StandardCharsets.UTF_8));
        return "File '" + fileName + "' updated successfully!";
    }

    // 4. DELETE (DELETE)
    @DeleteMapping("/delete")
    public String deleteBlob(@RequestParam String fileName) {
        boolean deleted = storage.delete(BlobId.of(bucketName, fileName));
        return deleted ? "File deleted!" : "File not found or could not be deleted.";
    }

	}

