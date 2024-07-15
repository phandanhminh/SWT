package com.example.swp_jewelryproductionordersystem.api;
import com.example.swp_jewelryproductionordersystem.entities.Accounts;
import com.example.swp_jewelryproductionordersystem.services.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping
    public ResponseEntity<List<Accounts>> getAllAccounts() {
        List<Accounts> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accounts> getAccountById(@PathVariable int id) {
        Accounts account = accountService.getAccountById(id);
        if (account == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(account);
    }

    @PostMapping("/register")
    public ResponseEntity<Accounts> createAccount(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam String phone, @RequestParam String address) {
        Accounts newAccount = new Accounts();
        newAccount.setName(name);
        newAccount.setEmail(email);
        newAccount.setPassword(password);
        newAccount.setPhone(phone);
        newAccount.setDeposit(0);
        newAccount.setAddress(address);
        newAccount.setRole("US");
        newAccount.setStatus(1);

        Accounts savedAccount = accountService.saveOrUpdateAccount(newAccount);
        return ResponseEntity.ok(savedAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accounts> updateAccount(@PathVariable int id, @RequestBody Accounts account) {
        account.setId(id);
        Accounts updatedAccount = accountService.saveOrUpdateAccount(account);
        return ResponseEntity.ok(updatedAccount);
    }

    @PutMapping("/role/{id}")
    public ResponseEntity<Accounts> updateRole(@PathVariable int id, @RequestBody Accounts account) {
        Accounts existingAccount = accountService.getAccountById(id);
        if (existingAccount == null) {
            return ResponseEntity.notFound().build();
        }
        existingAccount.setRole(account.getRole());
        existingAccount.setStatus(account.getStatus());

        Accounts savedAccount = accountService.saveOrUpdateAccount(existingAccount);
        return ResponseEntity.ok(savedAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Accounts> authenticateUser(@RequestParam String email, @RequestParam String password) {
        System.out.println(email);
        System.out.println(password);
        Accounts authenticatedAccount = accountService.authenticate(email, password);
        if (authenticatedAccount == null) {
            return ResponseEntity.status(401).build(); // Unauthorized
        }
        return ResponseEntity.ok(authenticatedAccount);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // Logout logic here, if applicable
        return ResponseEntity.ok("User logged out successfully");
    }
}
