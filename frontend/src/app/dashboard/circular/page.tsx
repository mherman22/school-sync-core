import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Textarea } from "@/components/ui/textarea"

export default function CircularPage() {
  return (
    <div className="space-y-6">
      <h1 className="text-3xl font-bold text-black">Print Circular</h1>
      <Card>
        <CardHeader>
          <CardTitle className="text-2xl text-black">Create New Circular</CardTitle>
          <CardDescription className="text-gray-600">Compose and print a new circular for distribution.</CardDescription>
        </CardHeader>
        <CardContent>
          <form className="space-y-4">
            <Input className="bg-white text-black border-gray-300" placeholder="Circular Subject" />
            <Textarea className="bg-white text-black border-gray-300" placeholder="Circular Content" rows={6} />
            <Input className="bg-white text-black border-gray-300" type="date" />
            <Button className="bg-blue-600 text-white hover:bg-blue-700">Print Circular</Button>
          </form>
        </CardContent>
      </Card>

      <Card>
        <CardHeader>
          <CardTitle className="text-2xl text-black">Recent Circulars</CardTitle>
          <CardDescription className="text-gray-600">View and reprint recent circulars.</CardDescription>
        </CardHeader>
        <CardContent>
          <div className="space-y-4">
            <div className="flex justify-between items-center p-4 bg-gray-100 rounded-md">
              <span className="text-black font-medium">End of Term Exams - 15/05/2023</span>
              <Button variant="outline" className="text-blue-600 border-blue-600 hover:bg-blue-50">Reprint</Button>
            </div>
            <div className="flex justify-between items-center p-4 bg-gray-100 rounded-md">
              <span className="text-black font-medium">Parent-Teacher Meeting - 01/06/2023</span>
              <Button variant="outline" className="text-blue-600 border-blue-600 hover:bg-blue-50">Reprint</Button>
            </div>
          </div>
        </CardContent>
      </Card>
    </div>
  )
}
