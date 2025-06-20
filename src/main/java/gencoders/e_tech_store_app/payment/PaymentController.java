package gencoders.e_tech_store_app.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public Payment create(@RequestBody PaymentDto dto) {
        return paymentService.createPayment(dto);
    }

    @GetMapping
    public List<Payment> getAll() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @PutMapping("/update/{id}")
    public Payment update(@PathVariable Long id, @RequestBody PaymentDto dto) {
        return paymentService.updatePayment(id, dto);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}
